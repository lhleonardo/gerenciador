package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;
import br.com.alura.gerenciador.util.WebUtil;

@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

		String filtro = req.getParameter("filtro");

		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);

		preparaWriter(empresas, resp.getWriter());
	}

	private void preparaWriter(Collection<Empresa> empresas, PrintWriter writer) {
		WebUtil.header(writer);
		
		writer.println("Resultado da busca:<br/>");
		writer.println("<ul>");

		for (Empresa empresa : empresas) {
			writer.println(String.format("<li>%d:%s</li>", empresa.getId(), empresa.getNome()));
		}
		writer.println("</ul>");

		WebUtil.footer(writer);
	}

	
}
