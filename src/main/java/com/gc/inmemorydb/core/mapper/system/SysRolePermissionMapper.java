package com.gc.inmemorydb.core.mapper.system;

import com.gc.inmemorydb.core.entity.system.SysRoleResource;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Licoy
 * @version 2018/4/16/9:00
 */
@Mapper
@Repository
public interface SysRolePermissionMapper extends BaseMapper<SysRoleResource> {
}
