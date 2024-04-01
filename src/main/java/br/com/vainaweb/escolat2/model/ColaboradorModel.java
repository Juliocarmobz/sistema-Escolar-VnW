package br.com.vainaweb.escolat2.model;

import org.hibernate.validator.constraints.br.CPF;

import br.com.vainaweb.escolat2.enums.Cargo;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //Trata a classe como entidade
@Table(name = "tb_colaboradores") //Defino o nome da minha tabela

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorModel {
	
	@Id //Determina a chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //TRANFORMA O ID EM AUTOINCREMET
	private Long id;
	
	private String nome;
	
	@Email
	@Column(unique = true) //Valores tem que ser únicos
	private String email;
	
	@CPF
	@Column(unique = true)
	private String cpf;
	
	private Cargo cargo;
	
	@Embedded // Diz que o atributo é incorporável
	private Endereco endereco;
	
	//---------------------------------construtor------------------------------
	
	public ColaboradorModel(String nome, String cpf, String email, Cargo cargo) {
		this.nome = nome;
		this.cpf = cpf;
		this.email =email;
		this.cargo = cargo;
	}
}
