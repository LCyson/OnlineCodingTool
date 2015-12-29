package OCServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class OCServer {
	
	public static void main(String [] args) throws IOException{
//		if (args.length != 1) {
//			System.out.println("Error input");
//			System.exit(1);
//		}
		
//		int port = Integer.parseInt(args[0]);
		int port = 6789;
		boolean listening = true;
        
        try (ServerSocket serverSocket = new ServerSocket(port)) { 
            while (listening) {
	            new OCServerThread(serverSocket.accept()).start();
	        }
	    } catch (IOException e) {
            System.err.println("Could not listen on port " + port);
            System.exit(-1);
        }
	}
}
