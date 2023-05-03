package com.pricesmanager.application;

import com.pricesmanager.domain.Price;
import com.pricesmanager.domain.PriceDetails;
import com.pricesmanager.infra.inputport.PricesInputPort;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.util.Assert;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class PricesUseCaseTest {

    private final PricesInputPort pricesInputPort;

    public PricesUseCaseTest(PricesInputPort pricesInputPort){
        this.pricesInputPort = pricesInputPort;
    }

    @Test
    public void getPrice(){

        PriceDetails pricesDetails = PriceDetails
                .builder()
                .applicationDate(LocalDateTime.of(2020, 06, 15, 16, 30, 59, 999))
                .brandId("1")
                .productId("35455")
                .build();


        Optional<Price> optionalPrice = pricesInputPort.getPrice(pricesDetails);

        Price price  = optionalPrice.orElse(null);


        Assert.isTrue(price != null, "No se encontró el precio en la base");
        Assert.isTrue(price.getValue() == 35.50, "El precio no coincide con lo esperado");
    }

}
