package com.gc.inmemorydb.core.entity.system;

import lombok.Data;

import java.io.Serializable;

@Data
public class Report implements Serializable {

    private Integer fnumber;

    private String company;

    private String city;
}
