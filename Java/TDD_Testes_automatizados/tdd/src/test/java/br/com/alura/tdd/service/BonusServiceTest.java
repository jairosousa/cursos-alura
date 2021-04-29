package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Deve calcular bonus Zero Funcionario com salario muito alto")
    void calcularBonusMaior10PorCentosTest() {
        BonusService service = new BonusService();
        // assertThrows(IllegalArgumentException.class,
        //        () -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));

        try {
            service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
            fail("Não deu exception");
        } catch (Exception e) {
            assertEquals("Funcionario com salario maior que 10 mil não pode receber bônus", e.getMessage());

        }

    }

    @Test
    @DisplayName("Deve calcular bonus de 10% do salario do Funcionario")
    void calcularBonus10porCentoTest() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);

    }

    @Test
    @DisplayName("Deve calcular bonus com salario de exatamente 10 mil do Funcionario")
    void calcularBonusTest() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000.00")));

        assertEquals(new BigDecimal("1000.00"), bonus);

    }
}