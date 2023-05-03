package com.pricesmanager.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Getter
@ToString
public class PriceDetails {

    private String brandId;
    private String productId;
    private LocalDateTime applicationDate;
}
