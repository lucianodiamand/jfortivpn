package ar.diamand.jfortivpn.yaml;

import java.util.List;

public class JFortivpnConfig {

	private List<ProfileConfig> profiles;

	public List<ProfileConfig> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<ProfileConfig> profiles) {
		this.profiles = profiles;
	}

	public ProfileConfig first() {
		return profiles.get(0);
	}

}
