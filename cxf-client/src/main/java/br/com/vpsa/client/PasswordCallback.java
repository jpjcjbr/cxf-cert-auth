package br.com.vpsa.client;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ws.security.WSPasswordCallback;

public class PasswordCallback implements CallbackHandler {

	protected final Log logger = LogFactory.getLog(getClass());

	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {

		for (int i = 0; i < callbacks.length; i++) {
			WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];

			int usage = pc.getUsage();
			logger.debug("identifier: " + pc.getIdentifier());
			logger.debug("usage: " + pc.getUsage());

			if (usage == WSPasswordCallback.USERNAME_TOKEN) {
				// username token pwd...
				pc.setPassword("password");
			} else if (usage == WSPasswordCallback.SIGNATURE) {
				// set the password for client's keystore.keyPassword
				pc.setPassword("ws-client_pass");
			}
		}
	}

}
