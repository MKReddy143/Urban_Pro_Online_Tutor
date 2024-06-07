package com.java.OptionalClasses;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientChat {
public static void main(String[] args) {
	try {
		ServerSocket serversock = new ServerSocket(6764);
		System.out.println("Server  ready you can send message");
		Socket sock = serversock.accept();
		BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
		OutputStream ostream = sock.getOutputStream();
		PrintWriter out = new PrintWriter(ostream, true);
		InputStream istream = sock.getInputStream();
		BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
		String receiveMessage, sendMessage;
		while (true) {
			if ((receiveMessage = receiveRead.readLine()) != null) {
				System.out.println(receiveMessage);
			}
			sendMessage = keyRead.readLine();
			out.println(sendMessage);
			out.flush();
		}
	} catch (Exception e) {
		System.out.println("client chat disconnected");
	}

}
}
