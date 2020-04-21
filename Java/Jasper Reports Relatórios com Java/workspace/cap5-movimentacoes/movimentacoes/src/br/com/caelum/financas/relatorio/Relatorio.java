package br.com.caelum.financas.relatorio;

import net.sf.jasperreports.engine.JRException;

import java.io.IOException;
import java.sql.Connection;

public interface Relatorio {
    Relatorio exportar(String jasper, Connection conexao) throws IOException, JRException;
}
