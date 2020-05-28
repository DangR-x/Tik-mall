package com.nongguoguo.Website.domain;

import lombok.Data;

/**
 *
 */
@Data
public class Rule {

    private String code="goodReputation";
    private String codeStr="好评送";
    private double confine=0.00;
    private Integer maxPerDay=0;
    private Integer score=3;

}
