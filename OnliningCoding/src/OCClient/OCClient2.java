package OCClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class OCClient2 {

	public OCClient2() {
		try {
			System.out.println("Starting Client");
			Socket s = new Socket("localhost", 6789);
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter pw = new PrintWriter(s.getOutputStream());
			boolean listening = true;
			
			String str = "Who's there?";
			System.out.println(str);
			pw.println(str);
			pw.flush();
			String line = br.readLine();
			System.out.println("Line Received: " + line);
			while (listening) 
			{
				line = br.readLine();
				System.out.println("Line Received: " + line);
				
			}
			pw.close();
			br.close();
			s.close();
		} catch (IOException ioe) {
			System.out.println("IOE: " + ioe.getMessage());
		}
	}	

	public static void main(String [] args) {
		new OCClient2();
	} 
}