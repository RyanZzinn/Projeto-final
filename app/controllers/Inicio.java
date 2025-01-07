package controllers;

import java.util.List;

import models.CadastrarLocal;
import models.CadastrarPessoa;
import play.mvc.Controller;

public class Inicio extends Controller {

	public static void form2() {
		render();
	}

	public static void list(String termo) {
		List<CadastrarLocal> cadastrarL = null;
		if (termo == null) {
			cadastrarL = CadastrarLocal.findAll();
		} else {
			cadastrarL = CadastrarLocal.find("lower(nomeLocal) like ?1", "%" + termo.toLowerCase() + "%").fetch();
		}
		render(cadastrarL, termo);
	}

	public static void detalhar(Long id) {
		CadastrarLocal cadastrarL = CadastrarLocal.findById(id);
		render(cadastrarL);
	}

	public static void salvar(CadastrarPessoa p) {
		p.nome = p.nome.toLowerCase();
		p.email = p.email.toLowerCase();
		p.save();
		renderTemplate("Login/form.html");
	}

	public static void verFoto(Long id) {
		CadastrarLocal L = CadastrarLocal.findById(id);
		notFoundIfNull(L);
		response.setContentTypeIfNotSet(L.foto.type());
		renderBinary(L.foto.get());
	}
}
