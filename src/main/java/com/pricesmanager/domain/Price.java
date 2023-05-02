package com.pricesmanager.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class Price {

    private Date startDate;
    private Date endDate;
    private int productId;
    private double value;
    private int brandId;
    private int priceList;
}
