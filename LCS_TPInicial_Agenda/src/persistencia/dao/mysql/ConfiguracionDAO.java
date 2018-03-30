package persistencia.dao.mysql;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

import persistencia.conexion.ConfigConexion;

public class ConfiguracionDAO {

	public void crearArchivoDeConfiguracion(String path, ConfigConexion config) throws IOException {
		File archivo = new File(path);
		FileWriter filewriter = new FileWriter(archivo);
		BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
		PrintWriter printwriter = new PrintWriter(bufferedwriter);
		printwriter.write(config.getIp() + ";");
		printwriter.append(config.getPuerto() + ";");
		printwriter.append(config.getNombreBaseDatos());
		printwriter.append(config.getUsuario() + ";");
		printwriter.append(config.getPassword() + ";");
		printwriter.close();
		bufferedwriter.close();
		filewriter.close();
	}

	public ConfigConexion obtenerConfiguracion(String path) throws FileNotFoundException {
		ConfigConexion ret = null;
		File archivo = new File(path);
		if (archivo.exists()) {
			ret = new ConfigConexion();
			FileInputStream fis = new FileInputStream(path);
			Scanner scan = new Scanner(fis);
			String line = scan.nextLine();
			StringTokenizer tokens = new StringTokenizer(line, ";");
			ret.setIp(tokens.nextToken());
			ret.setPuerto(tokens.nextToken());
			ret.setNombreBaseDatos(tokens.nextToken());
			ret.setUsuario(tokens.nextToken());
			ret.setPassword(tokens.nextToken());
			scan.close();
			
			//System.out.println(line);
		}

		return ret;
	}
}
