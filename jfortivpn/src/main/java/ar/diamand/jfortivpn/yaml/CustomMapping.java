package ar.diamand.jfortivpn.yaml;

import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.constructor.Constructor;

public class CustomMapping {

	public static Constructor mapping() {
		TypeDescription customerDescriptor = new TypeDescription(ProfileConfig.class);

		customerDescriptor.substituteProperty("vpn_config", String.class, "getVpnConfig", "setVpnConfig");
		customerDescriptor.substituteProperty("otp_prompt", String.class, "getOtpPrompt", "setOtpPrompt");

		customerDescriptor.substituteProperty("search_delay", String.class, "getSearchDelay", "setSearchDelay");
		customerDescriptor.substituteProperty("search_sender", String.class, "getSearchSender", "setSearchSender");
		customerDescriptor.substituteProperty("search_mailbox", String.class, "getSearchMailbox", "setSearchMailbox");
		customerDescriptor.substituteProperty("search_within", String.class, "getSearchWithin", "setSearchWithin");
		customerDescriptor.substituteProperty("search_field", String.class, "getSearchField", "setSearchField");
		customerDescriptor.substituteProperty("search_regex", String.class, "getSearchRegex", "setSearchRegex");

		Constructor constructor = new Constructor(JFortivpnConfig.class);
		constructor.addTypeDescription(customerDescriptor);

		return constructor;
	}

}
