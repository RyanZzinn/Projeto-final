package controllers;

import models.CadastrarPessoa;
import play.libs.Crypto;
import play.mvc.Controller;

public class Login extends Controller {

	public static void form() {
		render();
	}

	public static void logar(String email, String senha) {

		CadastrarPessoa use = CadastrarPessoa.find("email = ?1 and senha = ?2 ", email, Crypto.passwordHash(senha))
				.first();

		if (use == null) {
			form();
		} else {
			session.put("usuario.email", use.email);
			session.put("usuario.nome", use.nome);
			session.put("usuario.id", use.id);
			renderTemplate("Cadastrar/list2.html");
		}
	}

	public static void sair() {
		session.clear();
		Inicio.list(null);
	}

}
