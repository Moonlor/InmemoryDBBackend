package com.gc.inmemorydb.core.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.gc.inmemorydb.core.entity.system.Ticketorder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.gc.inmemorydb.core.entity.system.OrderInfo;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import java.util.List;

/**
 * @author STY
 * @version 2018/12/9/14:18
 */
@Mapper
@Repository
public interface OrderMapper extends BaseMapper<Ticketorder> {
    List<OrderInfo> getOrderInfoList(Pagination page, @Param("uId") String uId);
    void deleteOrder(@Param("orderId") String orderId);
}
