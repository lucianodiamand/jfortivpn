package ar.diamand.jfortivpn.email;

import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import ar.diamand.jfortivpn.util.StringUtil;
import ar.diamand.jfortivpn.yaml.ProfileConfig;

public class ReceiveEmail {

	private static final int MAX_RETRIES = 5;

	private Properties props;

	private String host;
	private String user;
	private String pass;
	private String folder;
	private int delay;

	public ReceiveEmail(ProfileConfig profile) {
		host = profile.getImap().getHost();
		user = profile.getImap().getUsername();
		pass = profile.getImap().getPassword();
		folder = profile.getSearchMailbox();

		props = new Properties();
		props.setProperty("mail.imap.host", host);
		props.setProperty("mail.imap.user", user);
		props.setProperty("mail.imap.pass", pass);
		props.setProperty("mail.imap.folder", folder);

		String sDelay = profile.getSearchDelay();
		String delay = sDelay.substring(0, sDelay.length() - 1);
		this.delay = Integer.parseInt(delay) * 1000;
	}

	public String process() {
		Session emailSession = Session.getDefaultInstance(props);

		try (Store store = emailSession.getStore("imaps")) {
			store.connect(host, user, pass);

			int retry = 1;
			while (retry++ < MAX_RETRIES) {
				try (Folder inbox = store.getFolder(folder)) {
					inbox.open(Folder.READ_WRITE);

					Message[] messages = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
					if (messages.length != 0) {
						messages[0].setFlag(Flag.DELETED, true);
						return StringUtil.getNumber(messages[0].getSubject());
					}
				}
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException("Cannot get the code from email");
	}

}
