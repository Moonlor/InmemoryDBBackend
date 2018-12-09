package com.gc.inmemorydb.core.service.system.impl;

import com.gc.inmemorydb.core.dto.system.role.RoleUpdateDTO;
import com.gc.inmemorydb.common.exception.RequestException;
import com.gc.inmemorydb.core.dto.system.role.FindRoleDTO;
import com.gc.inmemorydb.core.dto.system.role.RoleAddDTO;
import com.gc.inmemorydb.core.entity.system.SysResource;
import com.gc.inmemorydb.core.entity.system.SysUserRole;
import com.gc.inmemorydb.core.mapper.system.SysRoleMapper;
import com.gc.inmemorydb.core.service.global.ShiroService;
import com.gc.inmemorydb.core.service.system.SysRoleResourceService;
import com.gc.inmemorydb.core.service.system.SysRoleService;
import com.gc.inmemorydb.core.service.system.SysUserRoleService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gc.inmemorydb.core.entity.system.SysRole;
import com.gc.inmemorydb.core.entity.system.SysRoleResource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper,SysRole> implements SysRoleService{

    @Autowired
    private SysRoleResourceService roleResourceService;

    @Autowired
    private SysUserRoleService userRoleService;

    @Autowired
    private ShiroService shiroService;

    @Override
    public List<SysRole> findAllRoleByUserId(String uid,Boolean hasResource) {
        List<SysUserRole> userRoles = userRoleService.selectList(new EntityWrapper<SysUserRole>().eq("uuuid", uid));
        List<SysRole> roles = new ArrayList<>();
        userRoles.forEach(v->{
            SysRole role = this.selectById(v.getRid());
            if(role!=null){
                if(hasResource){
                    List<SysResource> permissions = roleResourceService.findAllResourceByRoleId(role.getId());
                    role.setResources(permissions);
                }
            }
            roles.add(role);
        });
        return roles;
    }

    @Override
    public Page<SysRole> list(FindRoleDTO findRoleDTO) {
        EntityWrapper<SysRole> wrapper = new EntityWrapper<>();
        wrapper.orderBy("id",findRoleDTO.getAsc());
        Page<SysRole> rolePage = this.selectPage(new Page<>(findRoleDTO.getPage(),
                findRoleDTO.getPageSize()), wrapper);
        if(findRoleDTO.getHasResource()){
            if(rolePage.getRecords()!=null){
                rolePage.getRecords().forEach(v->
                        v.setResources(roleResourceService.findAllResourceByRoleId(v.getId())));
            }
        }
        return rolePage;
    }

    @Override
    public void remove(String rid) {
        SysRole role = this.selectById(rid);
        if(role==null) throw RequestException.fail("角色不存在！");
        try {
            this.deleteById(rid);
            this.updateCache(role,true,false);
        }catch (DataIntegrityViolationException e){
            throw RequestException.fail(
                    String.format("请先解除角色为 %s 角色的全部用户！",role.getName()),e);
        }catch (Exception e){
            throw RequestException.fail("角色删除失败！",e);
        }
    }

    @Override
    public void update(String rid, RoleUpdateDTO roleUpdateDTO) {
        SysRole role = this.selectById(rid);
        if(role==null) throw RequestException.fail("角色不存在！");
        BeanUtils.copyProperties(roleUpdateDTO,role);
        try {
            this.updateById(role);
            roleResourceService.delete(new EntityWrapper<SysRoleResource>()
                    .eq("rid",rid));
            for (SysResource sysResource : roleUpdateDTO.getResources()) {
                roleResourceService.insert(SysRoleResource.builder()
                        .pid(sysResource.getId())
                        .rid(role.getId())
                        .build());
            }
            this.updateCache(role,true,false);
        }catch (Exception e){
            throw RequestException.fail("角色更新失败！",e);
        }

    }

    @Override
    public void add(RoleAddDTO addDTO) {
        SysRole role = this.selectOne(new EntityWrapper<SysRole>().eq("name",addDTO.getName()));
        if(role!=null){
            throw RequestException.fail(
                    String.format("已经存在名称为 %s 的角色",addDTO.getName()));
        }
        role = new SysRole();
        BeanUtils.copyProperties(addDTO,role);
        try {
            this.insert(role);
            for (SysResource sysResource : addDTO.getResources()) {
                roleResourceService.insert(SysRoleResource.builder()
                        .pid(sysResource.getId())
                        .rid(role.getId())
                        .build());
            }
        }catch (Exception e){
            throw RequestException.fail("添加失败",e);
        }
    }

    @Override
    public void updateCache(SysRole role,Boolean author, Boolean out) {
        List<SysUserRole> sysUserRoles = userRoleService.selectList(new EntityWrapper<SysUserRole>()
                .eq("rid", role.getId())
                .groupBy("uuuid"));
        List<String> userIdList = new ArrayList<>();
        if(sysUserRoles!=null && sysUserRoles.size()>0){
            sysUserRoles.forEach(v-> userIdList.add(v.getUuuid()));
        }
        shiroService.clearAuthByUserIdCollection(userIdList,author,out);
    }
}
