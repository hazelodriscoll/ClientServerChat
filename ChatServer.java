import java.net.*;
import java.io.*;
//Creates instance of a server and allows for server-client messaging through sockets. 
public class ChatServer {
	
	  public static void main(String[] args) throws Exception {
		  
	    try{
	    	
	      ServerSocket serverSocket = new ServerSocket(5000); 
	      
	      int counter = 0; //handles message requests on number they come in
	      System.out.println("[Server Initialised] - Awaiting Client Communication");
	      
	      while(true){
	        counter++; //For each client that joins, the counter goes up one and assigns that number to the client
	        Socket socket = serverSocket.accept();  //server accept the client connection request
	        ServerClientHandler serverClientHandler = new ServerClientHandler(socket,counter); //send  the request to a separate thread
	        serverClientHandler.start();
	      }
	    }catch(Exception e){
	      System.out.println(e);//Print out any exceptions that might occur
	    }
	  }
}
