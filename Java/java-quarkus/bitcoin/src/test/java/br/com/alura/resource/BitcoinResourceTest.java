package br.com.alura.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Autor Jairo Nascimento
 * @Created 31/08/2021 - 15:24
 */
@QuarkusTest
public class BitcoinResourceTest {

    @Test
    public void testarStatysCodeDaRequisicaoE200() {
        RestAssured
                .given().get("bitcoins").then().statusCode(200);
    }
}