package com.pricesmanager.application;

import com.pricesmanager.domain.Price;
import com.pricesmanager.domain.PriceDetails;
import com.pricesmanager.infra.inputport.PricesInputPort;
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

        PriceDetails pricesDetails = new PriceDetails();

        Price price = pricesInputPort.getPrice(pricesDetails);

        Assert.isTrue(price.getValue() == 34.50, "El precio no coincide con lo esperado");
    }

}
