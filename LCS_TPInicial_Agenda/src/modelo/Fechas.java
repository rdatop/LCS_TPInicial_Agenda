package modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

//@author  Henry Joe Wong Urquiza
public class Fechas {

	private static SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat formatoDeHora = new SimpleDateFormat("hh:mm:ss");

	// Metodo usado para obtener la fecha actual
	// @return Retorna un <b>STRING</b> con la fecha actual formato "dd/MM(yyyy"
	public static String getFechaActual() {
		Date ahora = new Date();
		return formatoDeFecha.format(ahora);
	}

	// Metodo usado para obtener la hora actual del sistema
	// @return Retorna un <b>STRING</b> con la hora actual formato "hh:mm:ss"
	public static String getHoraActual() {
		Date ahora = new Date();
		return formatoDeHora.format(ahora);
	}

	// Sumarle dias a una fecha determinada
	// @param fch La fecha para sumarle los dias
	// @param dias Numero de dias a agregar
	// @return La fecha agregando los dias
	public static java.sql.Date sumarFechasDias(java.sql.Date fch, int dias) {
		Calendar cal = new GregorianCalendar();
		cal.setTimeInMillis(fch.getTime());
		cal.add(Calendar.DATE, dias);
		return new java.sql.Date(cal.getTimeInMillis());
	}
	
	// Sumarle dias a una fecha determinada
	// @param fch La fecha para sumarle los dias
	// @param dias Numero de dias a agregar
	// @return La fecha agregando los dias
	public static java.sql.Date getFechasSQL(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTimeInMillis(date.getTime());
		return new java.sql.Date(cal.getTimeInMillis());
	}

	// Restarle dias a una fecha determinada
	// @param fch La fecha
	// @param dias Dias a restar
	// @return La fecha restando los dias
	public static synchronized java.sql.Date restarFechasDias(java.sql.Date fch, int dias) {
		Calendar cal = new GregorianCalendar();
		cal.setTimeInMillis(fch.getTime());
		cal.add(Calendar.DATE, -dias);
		return new java.sql.Date(cal.getTimeInMillis());
	}

	// Diferencias entre dos fechas
	// @param fechaInicial La fecha de inicio
	// @param fechaFinal La fecha de fin
	// @return Retorna el numero de dias entre dos fechas
	public static synchronized int diferenciasDeFechas(Date fechaInicial, Date fechaFinal) {

		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String fechaInicioString = df.format(fechaInicial);
		try {
			fechaInicial = df.parse(fechaInicioString);
		} catch (ParseException ex) {
		}

		String fechaFinalString = df.format(fechaFinal);
		try {
			fechaFinal = df.parse(fechaFinalString);
		} catch (ParseException ex) {
		}

		long fechaInicialMs = fechaInicial.getTime();
		long fechaFinalMs = fechaFinal.getTime();
		long diferencia = fechaFinalMs - fechaInicialMs;
		double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
		return ((int) dias);
	}

	// Devuele un java.util.Date desde un String en formato dd-MM-yyyy
	// @param La fecha a convertir a formato date
	// @return Retorna la fecha en formato Date
	public static synchronized java.util.Date deStringToDate(String fecha) {
		Date fechaEnviar = null;
		try {
			fechaEnviar = formatoDeFecha.parse(fecha);
			return fechaEnviar;
		} catch (ParseException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static synchronized String deDateToString(Date fecha) {
		return formatoDeFecha.format(fecha);
	}

}
