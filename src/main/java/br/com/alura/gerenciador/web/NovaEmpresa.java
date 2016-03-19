package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;
import br.com.alura.gerenciador.util.WebUtil;

@WebServlet(urlPatterns = "/novaEmpresa")
public class NovaEmpresa extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
		String nome = req.getParameter("nome");
		new EmpresaDAO().adiciona(new Empresa(nome));

		PrintWriter writer = resp.getWriter();
		WebUtil.header(writer);

		writer.append(String.format("<h2>Empresa %s adicionada com sucesso</h2>", nome));

		WebUtil.footer(writer);
	}
}
