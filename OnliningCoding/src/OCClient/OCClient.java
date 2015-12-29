package OCClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class OCClient {

	public OCClient() {
		try {
			System.out.println("Starting Client");
			Socket s = new Socket("localhost", 6789);
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter pw = new PrintWriter(s.getOutputStream());
			
			String str = "Line being sent";
			System.out.println("Sending: " + str);
			pw.println(str);
			pw.flush();
			String line = br.readLine();
			System.out.println("Line Received: " + line);
			pw.close();
			br.close();
			s.close();
		} catch (IOException ioe) {
			System.out.println("IOE: " + ioe.getMessage());
		}
	}	

	public static void main(String [] args) {
		new OCClient();
	} 
}