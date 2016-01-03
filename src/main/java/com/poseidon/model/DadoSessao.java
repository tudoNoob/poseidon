package com.poseidon.model;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class DadoSessao {

	private Integer id;

	private Long idUsuario;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "DadoSessao [id=" + id + ", idUsuario=" + idUsuario + "]";
	}

	
	
	
}
