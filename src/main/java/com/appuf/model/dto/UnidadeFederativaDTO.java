package com.appuf.model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "id", "dataCadastro" }) // nao exibir estes atributos no json
public class UnidadeFederativaDTO {
	
	private static final SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Long id;
	private String nomeEstado;
	private String uf;
	private Date dataCadastro;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public String getDataCadastroFormatada() {
		if (dataCadastro != null) {
			return formatoData.format(dataCadastro);
		}
		return "";
	}

}
