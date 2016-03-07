package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import model.User;

public class LoginController {

	File f = new File("/Users/brandonbocek/Documents/workspace/Room/userAndPass.txt");
	User user;
	String username;
	String password;
	
	public LoginController(String username, String password){
		
		user=new User(username, password);
		
	}
	
	
	/* Login methods */
	//returns 1 if the username doesn't exist
	//returns 2 if a username exists but password is incorrect
	//returns 3 if the username exists and the password is correct
	public int validateLogin(){
		String currentLine;
		String[] lineInfo;
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(f));
		}catch(FileNotFoundException exc){
			exc.printStackTrace();
			return 1;
		}
		try {
			while((currentLine = br.readLine()) != null){
				lineInfo=currentLine.split(",");
				if(user.getUsername().equals(lineInfo[0])){		//if a user name matches
					if(user.getPassword().equals(lineInfo[1])){		//if the corresponding password matches
						return 3;
					}
					return 2;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return 1;
		}
		return 1;
	}
}
