package controllers;

import models.CadastrarPessoa;
import play.mvc.Controller;

public class Login extends Controller {

	public static void form() {
		render();
	}

	public static void logar(String email, String senha) {

		CadastrarPessoa use = CadastrarPessoa.find("email = ?1 and senha = ?2 ", email, senha).first();

		if (use == null) {
			flash.success("erro");
			form();
		} else {
			session.put("usuario.email", use.email);
			session.put("usuario.nome", use.nome);
			renderTemplate("Inicio/list.html");
		}
	}
}
