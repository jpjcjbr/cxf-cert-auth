package br.com.vpsa.service;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ws.security.WSPasswordCallback;

public class PasswordCallbackHandler implements CallbackHandler {

	protected final Log logger = LogFactory.getLog(getClass());

	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {

		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		logger.debug("identifier: " + pc.getIdentifier());

		if (pc.getIdentifier().equals("ws-client")) {
			pc.setPassword("password");
		}
	}

}