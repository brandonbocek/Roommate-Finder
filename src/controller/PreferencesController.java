
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.User;

public class PreferencesController {
	User user;
	int dataLineIndex=0;
	File f = new File("/Users/brandonbocek/Documents/workspace/Room/info.txt");
	String lineData;
	
	public PreferencesController(ArrayList<String> param){
		user = new User();
		
		user.setUsername(param.get(0));
		user.setAgeStr(param.get(1));
		user.setMyGender(param.get(2));
		user.setSeekGender(param.get(3));
		user.setCleanliness(param.get(4));
		user.setInOut(param.get(5));
		user.setPersonality(param.get(6));
		user.setNoise(param.get(7));
		user.setSport(param.get(8));
		user.setMammal(param.get(9));
		user.setReptile(param.get(10));
		user.setSleep(param.get(11));
		user.setWake(param.get(12));
		user.setRealName(param.get(13));
		user.setEmail(param.get(14));
		lineData = user.getUsername() + "," + user.getAge() + "," + user.getMyGender() + ","
				+ user.getSeekGender()+","+user.getCleanliness()+","+user.getInOut()+","+
				user.getPersonality()+","+user.getNoise()+","+user.getSport()+","+user.getMammal()+","
				+user.getReptile()+","+user.getSleep()+","+user.getWake()+","+user.getRealName()+","+
				user.getEmail();
	}
	
	
	public void sendPersonalInfoToFile(){
		if(!f.exists()){
			makeMyFile();
		}
		if(!userHasDataAlreadyInFile()){
			appendInfoToFile();
			//System.out.println("new user, appended the file");
		}else{
			changeLineInfo();
			//System.out.println("old user, rewrote a line");
		}
	}

	//when a user wants to update their preferences, their line in the text file is changed
	private void changeLineInfo() {
		String lineToChange = lineData+"\n";
		try {

			BufferedReader reader = new BufferedReader(new FileReader(f));
			String line, before = "", after = "";
			int i = 0;
			
			while ((line = reader.readLine()) != null) {	//read line by line
				String[] els = line.split(",");				//divide the data on the line
				if(els[0].equals(user.getUsername())) {		//stop recording before the line to change
					i++;
				}else if (i==0) {							//save the data before the line to change
					before += line + "\n";
				}else if(i==1){								//save the data after the line to change
					after += line + "\n";
				}
			}
			reader.close();
			PrintWriter writer = new PrintWriter(f);
			writer.print("");	//clear everything in the file
			
			writer.print(before+lineToChange+after); 	//put all user info into the file
														//but the line is updated now
			writer.close();

		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	private void appendInfoToFile(){
		try {
			FileOutputStream fw = new FileOutputStream(f,true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(lineData);	//all the user's info is appended to the text file
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Couldn't write to file");
		}
	}
	private void makeMyFile(){
		try {
			f.createNewFile();
			System.out.println("Tried to create a new file");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to create the file");
		}
	}
	//returns true if user has data in file
	private boolean userHasDataAlreadyInFile(){
		String currentLine;
		String[] lineInfo;
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(f));
		}catch(FileNotFoundException exc){
			exc.printStackTrace();
		}
		try {
			while((currentLine = br.readLine()) != null){
				lineInfo=currentLine.split(",");
				if(lineInfo[0].equals(user.getUsername())){		//if a user name matches
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}catch(NullPointerException exc){
			exc.printStackTrace();
		}
		return false;
	}
}
