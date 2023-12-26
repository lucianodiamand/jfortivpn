package ar.diamand.jfortivpn.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;

import ar.diamand.jfortivpn.yaml.CustomMapping;
import ar.diamand.jfortivpn.yaml.JFortivpnConfig;

public class ConfigUtil {

	private ConfigUtil() {
		// Helper
	}

	public static JFortivpnConfig getConfig() {
		Yaml yaml = new Yaml(CustomMapping.mapping());
		try (InputStream inputStream = new FileInputStream("/home/user/.jfortivpn.yml")) {
			JFortivpnConfig config = yaml.load(inputStream);
			return config;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
