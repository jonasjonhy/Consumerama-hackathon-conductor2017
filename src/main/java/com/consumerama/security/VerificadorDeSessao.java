package com.consumerama.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.consumerama.model.Usuario;

@Component
public class VerificadorDeSessao {

	@Autowired
	private UserSession userSession;

	public boolean isSessaoAtiva() {
		Usuario usuario = userSession.getUsuario();
		if (usuario != null) {
			return true;
		}
		return false;
	}

}