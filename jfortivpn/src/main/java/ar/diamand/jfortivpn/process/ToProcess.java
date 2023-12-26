package ar.diamand.jfortivpn.process;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ToProcess implements Closeable {

	private BufferedWriter writer;

	public ToProcess(OutputStream os) {
		this.writer = new BufferedWriter(new OutputStreamWriter(os));
	}

	public void send(String data) {
		System.out.println(data);
		try {
			writer.write(data);
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() throws IOException {
		writer.close();
	}

}
