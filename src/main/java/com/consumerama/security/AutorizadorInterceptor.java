package com.consumerama.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private VerificadorDeSessao verificadorDeSessao;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
			throws Exception {
		
		String uri = request.getRequestURI();
		/*as URI's abaixo tem permissão de acesso sem necessitar de Login*/
		if (uri.endsWith("/index") || uri.endsWith("/logar") || uri.endsWith("/pagamento")
				|| uri.endsWith("/usuario/novo")) {
			return true;
		}
		
		/*Caso tenha uma sessão ativa, significa que o usuário se logou e pode acessar qualquer área do sistema*/
		if (verificadorDeSessao.isSessaoAtiva()) {
			return true;
		}

		/*caso o usuário não tenha se logado e tente acessar alguma uri que necessita de login ele será redirecionado para a uri abaixo*/
		response.sendRedirect("http://localhost:8080/index");
		return false;
	}

}