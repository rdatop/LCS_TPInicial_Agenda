package presentacion.reportes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import modelo.PersonaReporte;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReporteAgenda {
	private JasperReport reporte;
	private JasperViewer reporteViewer;
	private JasperPrint reporteLleno;
	private Map<String, Object> parametersMap;
	private static Properties prop = new Properties();

	// Recibe la lista de personas para armar el reporte
	public ReporteAgenda(List<PersonaReporte> personas) {
		try {
			prop.load(new FileInputStream("properties\\configuracion.properties"));
			
			parametersMap = new HashMap<String, Object>();
			parametersMap.put("Total", personas.size());
			
			this.reporte = (JasperReport) JRLoader.loadObjectFromFile(prop.getProperty("reporte"));
			this.reporteLleno = JasperFillManager.fillReport(this.reporte, parametersMap,
					new JRBeanCollectionDataSource(personas));
		} catch (JRException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void mostrar() {
		this.reporteViewer = new JasperViewer(this.reporteLleno, false);
		this.reporteViewer.setVisible(true);
	}

}