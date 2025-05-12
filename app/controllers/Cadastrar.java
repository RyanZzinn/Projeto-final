package controllers;

import java.util.List;

import models.CadastrarLocal;
import models.CadastrarPessoa;
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

	public static void detalhar(Long id, Long idpessoa) {
		List<CadastrarLocal> cadastrarL = CadastrarLocal.findAll();
		List<CadastrarPessoa> p = CadastrarPessoa.findAll();
		if (id == null) {
			render(null, idpessoa, cadastrarL, p);
		} else {
			CadastrarLocal pessoa = CadastrarLocal.findById(id);
			render(pessoa, idpessoa, cadastrarL, p);
		}
	}

	public static void salvar(CadastrarLocal c) {
		String emailUsuario = session.get("usuario.email");
		CadastrarPessoa pessoa = CadastrarPessoa.find("email = ?1", emailUsuario).first();
		
		c.nomeLocal = c.nomeLocal.toLowerCase();
		c.rua = c.rua.toLowerCase();
		c.bairro = c.bairro.toLowerCase();
		c.cidade = c.cidade.toLowerCase();
		c.vantagens = c.vantagens.toLowerCase();
		c.foto = c.foto;
		c.r = pessoa;
		c.save();
		list2(null);
	}

	public static void remover(Long id) {
		CadastrarLocal c2 = CadastrarLocal.findById(id);
		c2.delete();
		list2(null);
	}

	public static void editar(Long id) {
		CadastrarLocal p = CadastrarLocal.findById(id);
		List<CadastrarLocal> c3 = CadastrarLocal.findAll();
		renderTemplate("Cadastar/form.html", p, c3);
	}

	public static void MeusLocais() {
		String emailUsuario = session.get("usuario.email");
		CadastrarPessoa pessoa = CadastrarPessoa.find("email = ?1", emailUsuario).first();
		List<CadastrarLocal> locais = CadastrarLocal.find("r = ?1", pessoa).fetch();
		render(locais);
	}
}