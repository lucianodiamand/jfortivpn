package ar.diamand.jfortivpn.process;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class FromProcess extends Thread implements Closeable {

	private InputStream in;
	private PrintStream out;
	private String pattern;

	public FromProcess(InputStream is) {
		this(is, System.out);
	}

	public FromProcess(InputStream is, PrintStream ps) {
		this.in = is;
		this.out = ps;
	}

	@Override
	public void run() {
		int cant;
		byte[] buff = new byte[256];
		try {
			while ((cant = in.read(buff)) != -1) {
				String data = new String(buff, 0, cant);
				out.print(data);
				if (pattern != null && data.contains(pattern)) {
					synchronized (this) {
						notify();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public synchronized void expect(String pattern) {
		this.pattern = pattern;
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}

	@Override
	public void close() throws IOException {
		in.close();
	}

}
