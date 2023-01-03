package br.com.alura.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    @Test
    @DisplayName("Deve domar dois numeros inteiros")
    public void deveriaSomarDoisNmerosPositivos() {
        Calculadora calc = new Calculadora();
        int soma = calc.somar(3, 7);

        Assertions.assertEquals(10, soma);

    }
}
