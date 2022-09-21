
import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.view.JasperViewer;

/*import net.sf.jasperreports.export.Exporter;*/
//import net.sf.jasperreports.engine.export.SimpleOutputStreamExporterOutput;
public class Main {

    public static void main(String[] args) throws Exception {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conexion = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");

        HashMap map = new HashMap();
        map.put("id_desde", 1);
        map.put("id_hasta", 10);
        JasperReport reporte = (JasperReport) JRLoader.loadObject("report1.jasper");
        //JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, conexion);
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, map, conexion);

        // Generar PDF
        /*JRExporter exporter = new JRPdfExporter();
        
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reportePDF.pdf"));
        exporter.exportReport(); */
        // Para visualizar el PDF 
        JasperExportManager.exportReportToPdfFile(jasperPrint, "report1.pdf");
        JasperViewer.viewReport(jasperPrint);
        //JasperPrintManager.printReport(jasperPrint, true);
    }
}
