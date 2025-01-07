package controllers;

import java.util.List;

import models.CadastrarLocal;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Cadastrar extends Controller {

	public static void form() {
		render();
	}

	public static void list2(String termo) {
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
		list2(null);
	}

}
