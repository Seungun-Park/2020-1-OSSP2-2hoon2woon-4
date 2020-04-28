package hoon2woon2;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Properties;

import javax.swing.JOptionPane;

/**
 * 2020-04-27
 * @author Seungun-Park
 * TCP Socket Client
 */

public class Client {
	
	private static final long serialVersionUID = -3752491464582754341L;
	
	static Socket socket;
	static OutputStream os;
	static InputStream is;
	static String sendMessage;
	static byte[] bytes;
	static final String inipath = "server.properties";
	
	Properties prop = new Properties();
	
	public Client(){
		try {
			socket = new Socket();
			prop.load(new FileInputStream(inipath));
			
			connect();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void connect() {
		try {
			if(!(socket.isConnected())) {
				socket.connect(new InetSocketAddress(prop.getProperty("ip"), Integer.parseInt(prop.getProperty("port"))));
		
				os = socket.getOutputStream();
				sendMessage = "Tetris-Client Connected";
				bytes = sendMessage.getBytes("UTF-8");
		
				os.write(bytes);;
				os.flush();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			socket.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean login() {
		try {
			connect();
			os = socket.getOutputStream();
			is = socket.getInputStream();
			
			sendMessage = "login request";
			bytes = sendMessage.getBytes("UTF-8");
			
			os.write(bytes);
			os.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
