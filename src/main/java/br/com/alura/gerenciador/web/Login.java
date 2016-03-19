package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;
import br.com.alura.gerenciador.util.WebUtil;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		Optional<Usuario> usuario = Optional.ofNullable(new UsuarioDAO().buscaPorEmailESenha(login, senha));

		PrintWriter writer = resp.getWriter();
		WebUtil.header(writer);

		if (usuario.isPresent()) {
			writer.append(String.format("<h1>Usuário logado: %s</h1>", login));
		} else {
			writer.append("<h1>Usuário ou senha incorretos</h1>");
		}

		WebUtil.footer(writer);

	}
}
