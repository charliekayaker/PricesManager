package com.pricesmanager.application;

import com.pricesmanager.domain.Price;
import com.pricesmanager.domain.PriceDetails;
import com.pricesmanager.infra.inputport.PricesInputPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class PricesUseCaseTest {

    private final PricesInputPort pricesInputPort;

    public PricesUseCaseTest(PricesInputPort pricesInputPort){
        this.pricesInputPort = pricesInputPort;
    }

    //Solamente ubicado para destacar que se conoce el funcionamiento de estos métodos.
    @BeforeEach
    public void beforeEach(){
      System.out.println("Se ha inciado un nuevo test . . . ");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("Ha finalizado el test . . . ");
    }

    @Test
    void getPriceTest0(){

        PriceDetails pricesDetails =  getPriceDetails(
                LocalDateTime.of(2020, 6, 14, 10, 0, 0, 0),
                "1", "35455"
        );

        Optional<Price> optionalPrice = pricesInputPort.getPrice(pricesDetails);

        Price price  = optionalPrice.orElse(null);

        Assert.isTrue(price != null, "No se encontró el precio en la base");
        Assertions.assertEquals(35.50, price.getValue(), "El precio no coincide con lo esperado." + price);
    }

    @Test
    void getPriceTest1(){

        PriceDetails pricesDetails =  getPriceDetails(
                LocalDateTime.of(2020, 6, 14, 16, 0, 0, 0),
                "1", "35455"
        );

        Optional<Price> optionalPrice = pricesInputPort.getPrice(pricesDetails);

        Price price  = optionalPrice.orElse(null);

        Assert.isTrue(price != null, "No se encontró el precio en la base");
        Assertions.assertEquals(35.50, price.getValue(), "El precio no coincide con lo esperado. " + price);
    }

    @Test
    void getPriceTest2(){

        PriceDetails pricesDetails =  getPriceDetails(
                LocalDateTime.of(2020, 6, 14, 21, 0, 0, 0),
                "1", "35455"
        );

        Optional<Price> optionalPrice = pricesInputPort.getPrice(pricesDetails);

        Price price  = optionalPrice.orElse(null);
        Assert.isTrue(price != null, "No se encontró el precio en la base");
        Assertions.assertEquals(35.50, price.getValue(), "El precio no coincide con lo esperado. " + price);
    }

    @Test
    void getPriceTest3(){

        PriceDetails pricesDetails =  getPriceDetails(
                LocalDateTime.of(2020, 6, 15, 10, 0, 0, 0),
                "1", "35455"
        );

        Optional<Price> optionalPrice = pricesInputPort.getPrice(pricesDetails);

        Price price  = optionalPrice.orElse(null);

        Assert.isTrue(price != null, "No se encontró el precio en la base");
        Assertions.assertEquals(35.50, price.getValue(), "El precio no coincide con lo esperado. " + price);
    }

    @Test
    void getPriceTest4(){

        PriceDetails pricesDetails =  getPriceDetails(
                LocalDateTime.of(2020, 6, 16, 21, 0, 0, 0),
                "1", "35455"
        );

        Optional<Price> optionalPrice = pricesInputPort.getPrice(pricesDetails);

        Price price  = optionalPrice.orElse(null);

        Assert.isTrue(price != null, "No se encontró el precio en la base");
        Assertions.assertEquals(35.50, price.getValue(), "El precio no coincide con lo esperado. " + price);
    }



    private PriceDetails getPriceDetails(LocalDateTime localDateTime, String brandId, String productId){
        return PriceDetails
                .builder()
                .applicationDate(localDateTime)
                .brandId(brandId)
                .productId(productId)
                .build();
    }

}
