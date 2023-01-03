package br.com.caelum.financas.relatorio;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRXlsExporter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class ExportXml implements Relatorio {
    @Override
    public Relatorio exportar(String jasper, Connection conexao) throws IOException, JRException {

        Map<String, Object> parametros = new HashMap<String, Object>();

        JasperPrint print = JasperFillManager.fillReport(jasper, parametros, conexao);
        OutputStream stream = new FileOutputStream(jasper+ ".xml");

        JRExporter exporter = new JRXlsExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
        exporter.exportReport();

        stream.close();
        return null;
    }
}
