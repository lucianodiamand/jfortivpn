
package ar.diamand.jfortivpn;

import ar.diamand.jfortivpn.email.ReceiveEmail;
import ar.diamand.jfortivpn.util.ConfigUtil;
import ar.diamand.jfortivpn.yaml.JFortivpnConfig;
import ar.diamand.jfortivpn.yaml.ProfileConfig;

public class App {

	public static void main(String[] args) {

		JFortivpnConfig config = ConfigUtil.getConfig();
		ProfileConfig profile = config.first();

		String[] commandArgs = new String[] { "openfortivpn", "-c", profile.getVpnConfig() };
		Command openfortivpn = new Command(commandArgs);

		ReceiveEmail ree = new ReceiveEmail(profile);

		openfortivpn.expect(profile.getOtpPrompt());
		openfortivpn.send(ree.process());
		openfortivpn.exec();
	}

}
