package com.gc.inmemorydb.core.mapper.system;

import com.gc.inmemorydb.core.entity.system.SysResource;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Licoy
 * @version 2018/4/20/16:35
 */
@Mapper
@Repository
public interface SysResourceMapper extends BaseMapper<SysResource> {
}
