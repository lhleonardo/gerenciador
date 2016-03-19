package br.com.alura.gerenciador.util;

import java.io.PrintWriter;

public class WebUtil {

	public static void header(PrintWriter writer) {
		writer.println("<html>");
		writer.println("<body>");
	}

	public static void footer(PrintWriter writer) {
		writer.println("</body>");
		writer.println("</html>");
	}
}
