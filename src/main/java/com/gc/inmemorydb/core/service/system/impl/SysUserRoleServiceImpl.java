package com.gc.inmemorydb.core.service.system.impl;

import com.gc.inmemorydb.core.entity.system.SysUserRole;
import com.gc.inmemorydb.core.mapper.system.SysUserRoleMapper;
import com.gc.inmemorydb.core.service.system.SysUserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Licoy
 * @version 2018/4/16/11:32
 */
@Service
@Transactional
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper,SysUserRole> implements SysUserRoleService {
}
