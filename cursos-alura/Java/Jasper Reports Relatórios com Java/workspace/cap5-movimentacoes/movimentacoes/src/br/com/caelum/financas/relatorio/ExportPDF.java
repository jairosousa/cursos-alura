package br.com.caelum.financas.relatorio;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class ExportPDF implements Relatorio {

    @Override
    public Relatorio exportar(String jasper, Connection conexao) throws FileNotFoundException, JRException {
        Map<String, Object> param = new HashMap<>();

//		Preencher o relatório com parâmetros e os dados
        JasperPrint print = JasperFillManager.fillReport(jasper, param, conexao);

        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream(jasper + ".pdf"));
        exporter.exportReport();
        return null;
    }
}
