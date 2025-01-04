package controllers;

import java.util.List;

import models.CadastrarLocal;
import play.mvc.Controller;

public class Inicio extends Controller {

	public static void form() {
		render();
	}

	public static void detalhar(Long id) {
		CadastrarLocal local = CadastrarLocal.findById(id);
		render(local);
	}

	public static void salvar(CadastrarLocal c) {
		c.nomeLocal = c.nomeLocal.toLowerCase();
		c.rua = c.rua.toLowerCase();
		c.bairro = c.bairro.toLowerCase();
		c.cidade = c.cidade.toLowerCase();
		c.vantagens = c.vantagens.toLowerCase();
		c.save();
	}

	public static void list() {
		List<CadastrarLocal> CadastrarL = CadastrarLocal.findAll();
		render(CadastrarL);
	}

	public static void verFoto(Long id) {
		CadastrarLocal L = CadastrarLocal.findById(id);
		notFoundIfNull(L);
		response.setContentTypeIfNotSet(L.foto.type());
		renderBinary(L.foto.get());
	}
}
