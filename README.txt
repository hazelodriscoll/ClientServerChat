 ___________________________________________________
* GMIT - Dept. Computer Science & Applied Physics   *
*                                                   *
*           Server Client Chat Programme V0.1       *
*     H.Dip in Science (Software Development)       *
*               Hazel O'Driscoll   		      *
*           				 		      *
*___________________________________________________*



[DESCRIPTION OF APPLICATION]

- This application allows for private Server Client communication through individual conversations. It contains three classes:
	ChatServer -> 	Deals with the server side functionality.
					-Creates an instance of the server and allows for server-client messaging.
					-Creates instance of the class ServerClientHandler

	ChatClient -> 	Deals with the client side functionality.
					-Using input and output streams plus BufferedReader for the sending and recieving of messages.

	ServerClientHandler -> Deals with the thread side functionality, allowing multiple clients to connect at once.

[RUNNING OF APPLICATION]

- To run, user must open an instance of Server first in command prompt or chosen method. Then in a seperate window, can create an instance of the first Client, 
and so on for further Clients.
- Once the server is instantiated it then waits for communication from a client.
- Clients are delegated numbers in order of arrival, e.g. Client#1 will be the first client and it will increase by one each time a new Client joins.
- The delegation of numbers to the clients allows for ease of handling for the server and to avoid confusion.
- Each chat is private, the other clients cannot view messages sent from other clients.
- The server however can view each message as they come in. 
- The server must respond before a new request/message can be processed.
- If the client can’t reach the server when it starts up, an exception is thrown and a description of the exception is printed out to user.

-The IP address is set to localhost, the current computer, which is "127.0.0.1". 
-The port number is also set within the ChatServer class and the ChatClient class currently to "5000".
This can be edited within IDE but must be the same port for both in order for application to run.

-To exit: type '\q', once acknowledged by the server through any message response, client exits application and it is printed to the server console that they have left.

[RESOURCES]
-Code snippets taken and altered from:

http://net-informations.com/java/net/multithreaded.htm
Net-informations.com, Multi-threaded Client/Server in Java

https://www.youtube.com/watch?v=gLfuZrrfKes
WittCode, Java Socket Programming - Multiple Clients Chat, AUG 17 2021

Other Resources:
-https://www.geeksforgeeks.org/socket-programming-in-java/
Souradeep Barua, Socket Programming in Java, Nov 08 2021

-http://pirate.shu.edu/~wachsmut/Teaching/CSAS2214/Virtual/Lectures/chat-client-server.html
Wachsmut,Creating a simple Chat Client/Server Solution

-https://docs.oracle.com/javase/tutorial/networking/sockets/clientServer.html
Oracle, Writing the Server Side of a Socket

-Sources from Moodle
