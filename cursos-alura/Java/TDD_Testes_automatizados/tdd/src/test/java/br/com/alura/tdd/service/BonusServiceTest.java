package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    private BonusService service;

    @BeforeEach
    void setUp() {
        service = new BonusService();
    }

    @AfterEach
    void tearDown() {
    }

    @BeforeAll
    public static void antesDeTodos() {
        System.out.println("Antes de todos");
    }

    @BeforeAll
    public static void depoisDeTodos() {
        System.out.println("Depois de todos");
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
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));
        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    @DisplayName("Deve calcular bonus com salario de exatamente 10 mil do Funcionario")
    void calcularBonusTest() {
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000.00")));
        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}