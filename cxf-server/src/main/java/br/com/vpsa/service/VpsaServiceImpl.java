package br.com.vpsa.service;

import javax.jws.WebService;

@WebService( endpointInterface = "br.com.vpsa.service.VpsaService" )
public class VpsaServiceImpl implements VpsaService{

	@Override
	public String getMensagem(String parametro) {
		return parametro + " ----- " + parametro;
	}

}
