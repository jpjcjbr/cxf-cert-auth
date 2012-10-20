package br.com.vpsa.service;

import javax.jws.WebService;

@WebService
public interface VpsaService {
	
	String getMensagem(String parametro);
}
