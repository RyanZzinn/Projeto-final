package controllers;

import java.util.List;

import models.CadastrarLocal;
import play.mvc.Controller;

public class Inicio extends Controller {

	public static void list(String termo) {

		List<CadastrarLocal> cadastrarL = null;
		if (termo == null) {
			cadastrarL = CadastrarLocal.findAll();
		} else {
			cadastrarL = CadastrarLocal.find("lower(nomeLocal) like ?1", "%" + termo.toLowerCase() + "%").fetch();
		}
		render(cadastrarL, termo);
	}

	public static void salvar(CadastrarLocal c) {
		c.nomeLocal = c.nomeLocal.toLowerCase();
		c.rua = c.rua.toLowerCase();
		c.bairro = c.bairro.toLowerCase();
		c.cidade = c.cidade.toLowerCase();
		c.vantagens = c.vantagens.toLowerCase();
		c.foto = c.foto;
		c.save();
		list(null);
	}

	public static void detalhar(Long id) {
		CadastrarLocal cadastrarL = CadastrarLocal.findById(id);
		render(cadastrarL);
	}

	public static void verFoto(Long id) {
		CadastrarLocal L = CadastrarLocal.findById(id);
		notFoundIfNull(L);
		response.setContentTypeIfNotSet(L.foto.type());
		renderBinary(L.foto.get());
	}
}
