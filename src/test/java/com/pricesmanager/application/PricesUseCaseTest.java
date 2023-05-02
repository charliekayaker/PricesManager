package com.pricesmanager.application;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.util.Assert;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class PricesUseCaseTest {

    private final PricesInputPort pricesInputPort;

    public PricesUseCaseTest(PricesInputPort pricesInputPort){
        this.pricesInputPort = pricesInputPort;
    }

    @Test
    public void getPrice(){

        PricesDetails pricesDetails = new PriceDetails();

        Price price = pricesInputPort.getPrice(pricesDetails);

        Assert.isTrue(price.getValue() == 34.50, "El precio no coincide con lo esperado");
    }

}
