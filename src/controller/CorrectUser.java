package controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import model.User;




public class CorrectUser {

	User user;
	
	File f = new File("/Users/brandonbocek/Documents/workspace/Room/userAndPass.txt");
	
	public CorrectUser(String username, String password, String rePassword){
		user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRepassword(rePassword);
	}
	
	/* Register new account methods */
	public int validateNewUser(){
		if(!user.getUsername().equals("")){
			if(!user.getPassword().equals("")){
				if(user.getPassword().equals(user.getRepassword())){
					if(validateLogin()==1){
						sendToFile();
						return 5;	//success
					}
					return 4;		//failure, user name is taken
				}
				return 3;			//failure, passwords don't match
			}
			return 2;				//failure, password is blank 
		}
		return 1;					//failure, user name is blank
	}
	
	//appends the user name and password to the file
	public void sendToFile(){
		
		if(!f.exists()){
			try {
				f.createNewFile();
				System.out.println("Tried to create a new file");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Failed to create the file");
			}
		}	
		try {
			FileOutputStream fw = new FileOutputStream(f,true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(user.getUsername()+","+user.getPassword());
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Couldn't write to file");
		}
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
