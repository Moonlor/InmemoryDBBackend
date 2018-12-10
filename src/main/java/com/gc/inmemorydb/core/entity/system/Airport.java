package com.gc.inmemorydb.core.entity.system;

import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZWZ
 * @version 2018/12/10/15:01
 */
@Data
public class Airport implements Serializable{

    @TableId
    private String cityCode;

    private String cityName;

    private String cityPinyin;

    private String airportName;

    private String airportCode;
}
