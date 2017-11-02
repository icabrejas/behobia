package org.behobia.scraping;

public class BehobiaURLBuilder {

	public static final String URL = "https://clasificacion.behobia-sansebastian.com/oficial.php";

	public static String get(int year, int skip) {
		return new StringBuilder().append(URL)
				.append("?lang=" + "es")
				.append("&accion=" + "buscar")
				.append("&tipo=" + "")
				.append("&ano=" + year)
				.append("&categoria=" + "")
				.append("&nombre=" + "")
				.append("&apellido=" + "")
				.append("&localidad=" + "")
				.append("&dorsal=" + "")
				.append("&paginacion=" + skip)
				.append("&siguiente=" + "1")
				.append("#ancla")
				.toString();
	}

}
