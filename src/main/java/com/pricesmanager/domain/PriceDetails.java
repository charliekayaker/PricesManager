package com.pricesmanager.domain;

import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

@Builder
@Getter
public class PriceDetails {

    private String brandId;
    private String productId;
    private Date applicationDate;
}
