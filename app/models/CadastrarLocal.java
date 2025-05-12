package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

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
	
	@Transient
	public List<Blob> fotos = new ArrayList<Blob>();
	
	@ManyToOne
	@JoinColumn(name = "idpessoa")
	public CadastrarPessoa r;
}
