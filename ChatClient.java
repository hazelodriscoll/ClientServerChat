import java.net.*;

import java.io.*;
//Uses data input and output streams plus buffered reader to send and recieve server-client messages.
//Only Server can see individual clients messages
public class ChatClient {
	
	  public static void main(String[] args) throws Exception {
	  try{
		  
	    Socket socket=new Socket("localhost",5000);
	    
	    DataInputStream inputStream = new DataInputStream(socket.getInputStream());
	    DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
	    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	    
	    String messageFromClient = "";
	    String messageFromServer = "";
	    
	    while(!messageFromClient.equals("\\q")){ //Allows user to quit out using \q once message is responded to by server
	      System.out.println("[Server ready: please enter response or to quit- type the backslash symbol + q]");
	      messageFromClient = bufferedReader.readLine();
	      outputStream.writeUTF(messageFromClient);
	      outputStream.flush(); //Have to flush bufferedreader as won't flush itself until full
	      messageFromServer = inputStream.readUTF();
	      System.out.println(messageFromServer);
	    }
	    
	    outputStream.close();
	    outputStream.close();
	    socket.close();
	    
	  }catch(Exception e){
	    System.out.println(e);
	  }
	  }
}
