/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.awt.Component;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author USER
 */
public class ControlReport {
       private Component mHome;

    //report preview
    public void previewReport(JasperPrint jp, String report) {
        try {
            JasperViewer.viewReport(jp, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mHome, e.getMessage());
        }
    }

    public void xlsExporter(JasperPrint jp, String fileName) {
        try {
            JRXlsExporter exporter = new JRXlsExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "G:\\java\\Penjualanlaptop\\" + fileName + ".xls");
            exporter.exportReport();
            JOptionPane.showMessageDialog(mHome, "Export To MS.Excel (.xls)  Success !");
        } catch (JRException | HeadlessException e) {
            JOptionPane.showMessageDialog(mHome, e.getMessage());
        }
    }

    public void rtfExporter(JasperPrint jp, String fileName) {
        try {
            JRRtfExporter exporter = new JRRtfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "G:\\java\\Penjualanlaptop\\" + fileName + ".rtf");
            exporter.exportReport();
            JOptionPane.showMessageDialog(mHome, "Export To MS.Word Success !");
        } catch (JRException | HeadlessException e) {
            JOptionPane.showMessageDialog(mHome, e.getMessage());
        }
    }

    public void pdfExporter(JasperPrint jp, String fileName) {
        try {
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "G:\\java\\Penjualanlaptop\\" + fileName + ".pdf");
            exporter.exportReport();
            JOptionPane.showMessageDialog(mHome, "Export To PDF Success !");
        } catch (HeadlessException | JRException e) {
            JOptionPane.showMessageDialog(mHome, e.getMessage());
        }
    }
}
