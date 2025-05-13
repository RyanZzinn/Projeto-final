package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class CadastrarLocal extends Model {

	public String nomeLocal;
	public String vantagens;
	public int valor;
	public String localização;
	public String rua;
	public String bairro;
	public int numero;
	public String cidade;
	public Blob foto;
	
	@ManyToOne
	@JoinColumn(name = "idpessoa")
	public CadastrarPessoa r;
}
