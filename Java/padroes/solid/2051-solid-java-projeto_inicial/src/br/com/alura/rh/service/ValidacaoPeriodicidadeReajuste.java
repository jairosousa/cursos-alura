package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class ValidacaoPeriodicidadeReajuste implements ValidacaoReajuste {

    public void validar(Funcionario funcionario, BigDecimal aumento) {

        if (Objects.nonNull(funcionario.getDataUltimoReajuste())) {

            LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
            LocalDate dataAtual = LocalDate.now();

            long mesesDeSeuUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
            if (mesesDeSeuUltimoReajuste < 6) {
                throw new ValidacaoException("Intervalo entre reajuste deve ser no minimo 6 meses");
            }
        }

    }
}
