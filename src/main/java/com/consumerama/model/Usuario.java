package com.consumerama.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
@SequenceGenerator(name="gerador", sequenceName="USUARIO_SEQ")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gerador")
	@Column(name="ID")
	private Long id;
	
	@Column(name="NOME")
	private String nome;
	@Column(name="EMAIL")
	private String email;
	@Column(name="ENDERECO")
	private String endereco;
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_USUARIO")
	private List<Pagamento> pagamentos;
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}