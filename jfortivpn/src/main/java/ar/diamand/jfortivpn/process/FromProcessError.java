package ar.diamand.jfortivpn.process;

import java.io.InputStream;

public class FromProcessError extends FromProcess {

	public FromProcessError(InputStream is) {
		super(is, System.err);
	}

}
