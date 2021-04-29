package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    @Test
    @DisplayName("Reajuste deve ser de 3% quando o desempenho for adesejar")
    public void reajusteDesempenhoADesejar() {
        ReajusteService service = new ReajusteService();

        Funcionario funcionario =
                new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));

        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    @DisplayName("Reajuste deve ser de 15% quando o desempenho for BOM")
    public void reajusteDesempenhoBom() {
        ReajusteService service = new ReajusteService();

        Funcionario funcionario =
                new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));

        service.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    @DisplayName("Reajuste deve ser de 20% quando o desempenho for ÓTIMO")
    public void reajusteDesempenhoOtimo() {
        ReajusteService service = new ReajusteService();

        Funcionario funcionario =
                new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));

        service.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
