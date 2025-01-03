package models;

import java.net.URL;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class CadastrarLocal extends Model {

	public String nomeLocal;
	public String vantagens;
	public int valor;
	public URL localização;
	public String rua;
	public String bairro;
	public int numero;
	public String cidade;

}
