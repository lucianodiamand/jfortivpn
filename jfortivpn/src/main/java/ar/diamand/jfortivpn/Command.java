package ar.diamand.jfortivpn;

import java.io.IOException;

import ar.diamand.jfortivpn.process.FromProcess;
import ar.diamand.jfortivpn.process.FromProcessError;
import ar.diamand.jfortivpn.process.ToProcess;

public class Command {

	private Process process;
	private ToProcess in;
	private FromProcess out;
	private FromProcessError error;

	public Command(String[] args) {
		ProcessBuilder builder = new ProcessBuilder();
		builder.command(args);

		try {
			process = builder.start();
			in = new ToProcess(process.getOutputStream());
			out = new FromProcess(process.getInputStream());
			error = new FromProcessError(process.getErrorStream());

			out.start();
			error.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void send(String data) {
		in.send(data);
	}

	public void expect(String pattern) {
		out.expect(pattern);
	}

	public void exec() {
		try {
			try {
				int exitCode = process.waitFor();
				System.out.println("Exited with error code: " + exitCode);
			} finally {
				error.close();
				out.close();
				in.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
