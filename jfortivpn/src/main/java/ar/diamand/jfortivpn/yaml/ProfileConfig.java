package ar.diamand.jfortivpn.yaml;

public class ProfileConfig {

	private String name;
	private String vpnConfig;
	private String otpPrompt;

	private String searchDelay;
	private String searchSender;
	private String searchMailbox;
	private String searchWithin;
	private String searchField;
	private String searchRegex;

	private ImapConfig imap;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVpnConfig() {
		return vpnConfig;
	}

	public void setVpnConfig(String vpnConfig) {
		this.vpnConfig = vpnConfig;
	}

	public String getOtpPrompt() {
		return otpPrompt;
	}

	public void setOtpPrompt(String otpPrompt) {
		this.otpPrompt = otpPrompt;
	}

	public String getSearchDelay() {
		return searchDelay;
	}

	public void setSearchDelay(String searchDelay) {
		this.searchDelay = searchDelay;
	}

	public String getSearchSender() {
		return searchSender;
	}

	public void setSearchSender(String searchSender) {
		this.searchSender = searchSender;
	}

	public String getSearchMailbox() {
		return searchMailbox;
	}

	public void setSearchMailbox(String searchMailbox) {
		this.searchMailbox = searchMailbox;
	}

	public String getSearchWithin() {
		return searchWithin;
	}

	public void setSearchWithin(String searchWithin) {
		this.searchWithin = searchWithin;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchRegex() {
		return searchRegex;
	}

	public void setSearchRegex(String searchRegex) {
		this.searchRegex = searchRegex;
	}

	public ImapConfig getImap() {
		return imap;
	}

	public void setImap(ImapConfig imap) {
		this.imap = imap;
	}

}
