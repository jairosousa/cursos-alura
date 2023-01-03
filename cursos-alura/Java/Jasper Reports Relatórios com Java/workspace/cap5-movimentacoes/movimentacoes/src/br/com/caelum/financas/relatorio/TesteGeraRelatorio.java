package br.com.caelum.financas.relatorio;

import br.com.caelum.financas.ConnectionFactory;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class TesteGeraRelatorio {

	public static void main(String[] args) throws SQLException, JRException, IOException {

//		primeiro compila o arquivo jrxml
		String jasper = JasperCompileManager.compileReportToFile("financas.jrxml");

		Connection conexao = new ConnectionFactory().getConnection();

		Relatorio pdf = new ExportPDF().exportar(jasper, conexao);
		Relatorio html = new ExportHtml().exportar(jasper, conexao);
		Relatorio xml = new ExportXml().exportar(jasper, conexao);

		conexao.close();
	}
}
