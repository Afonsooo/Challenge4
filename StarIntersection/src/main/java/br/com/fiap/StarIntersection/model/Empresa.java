package br.com.fiap.StarIntersection.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="TB_EMPRESA")
public class Empresa {
	@Id
	@Column(name="ID_Parceiro")
	private Long id; 
	
	@Column(nullable = false, name="CNPJ")
	private Long cnpj;
	
	@Column(nullable = false, name="NR_INSCRICAO_ESTADUAL")
	private Long inscricao;
	
	@Column(nullable = false, name="NM_FANTASIA")
	private Long nomeFantasia;
	
	public Empresa() {
	
	}

	public Empresa(Long id, Long cnpj, Long inscricao, Long nomeFantasia) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.inscricao = inscricao;
		this.nomeFantasia = nomeFantasia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public Long getInscricao() {
		return inscricao;
	}

	public void setInscricao(Long inscricao) {
		this.inscricao = inscricao;
	}

	public Long getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(Long nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	
	
}
