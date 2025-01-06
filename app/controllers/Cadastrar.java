package controllers;

import java.util.List;

import models.CadastrarPessoa;
import play.mvc.Controller;

public class Cadastrar extends Controller {

	public static void form() {
		render();
	}

	public static void form2() {
		render();
	}

	public static void salvar(CadastrarPessoa p) {
		p.nome = p.nome.toLowerCase();
		p.email = p.email.toLowerCase();
		p.save();
		list();
	}

	public static void list() {
		List<CadastrarPessoa> cadastrarP = CadastrarPessoa.findAll();
		render(cadastrarP);
	}
}
