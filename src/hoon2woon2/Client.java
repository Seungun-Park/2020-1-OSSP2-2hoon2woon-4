package hoon2woon2;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Client {
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
			socket.connect(new InetSocketAddress(prop.getProperty("ip"), Integer.parseInt(prop.getProperty("port"))));
			
			os = socket.getOutputStream();
			sendMessage = "Tetris-Client Connected";
			bytes = sendMessage.getBytes("UTF-8");
			
			os.write(bytes);;
			os.flush();
			
		} catch(IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "서버 접속에 실패했습니다. 오프라인으로 플레이합니다.");
		}
	}
}
