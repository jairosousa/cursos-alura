package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ReajusteServiceTest {

    ValidacaoReajuste validacaoReajuste = new ValidacaoPercentualReajuste();
    ValidacaoPeriodicidadeReajuste periodicidadeReajuste = new ValidacaoPeriodicidadeReajuste();

    List<ValidacaoReajuste> reajusteList = new ArrayList<>();

    ReajusteService service;
    Funcionario funcionario;

    @BeforeEach
    void setup() {
        reajusteList.add(validacaoReajuste);
        reajusteList.add(periodicidadeReajuste);
        service = new ReajusteService(reajusteList);

        funcionario = new Funcionario("João", "191", Cargo.ASSISTENTE, BigDecimal.valueOf(2000.00));

    }



    @Test
    void reajusteSalarioDoFuncionario() {

        service.reajusteSalarioDoFuncionario(funcionario, BigDecimal.valueOf(200.00));

        Assertions.assertEquals(BigDecimal.valueOf(2200.00), funcionario.getDadosPessoais().getSalario());
    }

    @Test
    void deveLancarExcecaoValorMaiorQuePermitido() {

        ValidacaoException exception = assertThrows(ValidacaoException.class,
                () -> service.reajusteSalarioDoFuncionario(funcionario, BigDecimal.valueOf(1000.00)));

        Assertions.assertEquals("Reajuste nao pode ser superior a 40% do salario!", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoPeriodoMenorQuePermitido() {

        funcionario.setDataUltimoReajuste(LocalDate.of(2020, 12,1));

        ValidacaoException exception = assertThrows(ValidacaoException.class,
                () -> service.reajusteSalarioDoFuncionario(funcionario, BigDecimal.valueOf(100.00)));

        Assertions.assertEquals("Intervalo entre reajuste deve ser no minimo 6 meses", exception.getMessage());
    }
}