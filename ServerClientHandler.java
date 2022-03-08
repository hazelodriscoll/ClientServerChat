import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
//Handles server-client on a numbered basis taken in from ChatServer.
public class ServerClientHandler extends Thread {
	
	private Socket socket;
	private int clientNumber;
	
	public ServerClientHandler(Socket inputSocket,int counter){
	    socket = inputSocket;
	    clientNumber = counter;
	  }
	  
	public void run(){
		try{
	      DataInputStream inputStream = new DataInputStream(socket.getInputStream());
	      DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
	      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	      
	      String messageFromClient = "";
	      String messageFromServer = "";
	      
	      while(!messageFromClient.equals("\\q")){ //allows user to exit once \q is entered once message is responded to by server
	        messageFromClient = inputStream.readUTF(); //read in message of strings
	        System.out.println("From Client#" +clientNumber+ ": "+ messageFromClient); //print message to server
	        messageFromServer="From Server to Client#" + clientNumber + ": " + bufferedReader.readLine(); //read input from server
	        outputStream.writeUTF(messageFromServer); //write message from server to respective client
	        outputStream.flush(); //flush to clear 
	      }
	      
	      inputStream.close();
	      outputStream.close();
	      socket.close();
	      
	    }catch(Exception ex){
	      System.out.println(ex); //prints out exception that might occur
	    }finally{
	      System.out.println("Client#" + clientNumber + " has left the chat.");
	    }
	  }
}
