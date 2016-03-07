package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.User;

public class Comparator {
	
	File f = new File("/Users/brandonbocek/Documents/workspace/Room/info.txt");
	User user;
	ArrayList<User> others = new ArrayList<User>();
	ArrayList othersInfo = new ArrayList();
	
	
	//the constructor for a brand new user, gets info from the jsp file
	public Comparator(ArrayList<String> param){
		user = new User(param);
	}
	
	//the constructor for a returning user must get their info from the text file
	public Comparator(String username){
		user = new User(username);
		getReturningUserInfo();//setting the rest of the parameters
	}
	
	//make the array list of people that aren't the user
	public void makeThePeople(){
			
		String currentLine;
		String[] lineInfo;
		BufferedReader br = null;
		ArrayList<String> temp = new ArrayList<String>(); 
			
		try {
			br = new BufferedReader(new FileReader(f));
				
			while((currentLine = br.readLine()) != null){ //read through all info lines
				lineInfo=currentLine.split(",");
				if(!user.getUsername().equals(lineInfo[0])){ //if a user name is different
					for(int i=0; i<15; i++){
						temp.add(lineInfo[i]);		//build up the arraylist
					}
					others.add(new User(temp)); 	//add the user to the list of others
					temp.clear();					//clear info for the next user
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//set the users preferences from the text file
	public void getReturningUserInfo(){
				
		String currentLine;
		String[] lineInfo;
		BufferedReader br = null;
				
		try {
			br = new BufferedReader(new FileReader(f));
					
			while((currentLine = br.readLine()) != null){
				lineInfo=currentLine.split(",");
				if(user.getUsername().equals(lineInfo[0])){		//if it's the user
					
				// set all the info to their user object
					user.setAgeStr(lineInfo[1]);
					user.setMyGender(lineInfo[2]);
					user.setSeekGender(lineInfo[3]);
					user.setCleanliness(lineInfo[4]);
					user.setInOut(lineInfo[5]);
					user.setPersonality(lineInfo[6]);
					user.setNoise(lineInfo[7]);
					user.setSport(lineInfo[8]);
					user.setMammal(lineInfo[9]);
					user.setReptile(lineInfo[10]);
					user.setSleep(lineInfo[11]);
					user.setWake(lineInfo[12]);
					user.setRealName(lineInfo[13]);
					user.setEmail(lineInfo[14]);	
				}
			}
				br.close();
		} catch (IOException e) {
				e.printStackTrace();
		}
				
		}
	public int getPercent(User mate){
		int percent = 100;
			
		if(((mate.getAge() - user.getAge()) > 6) && (mate.getAge() - user.getAge()) < -6){ //if ages aren't close enough
			percent-=10;
		}
		if(!user.getSeekGender().equals(mate.getMyGender())){ 	//if the mate isn't want you're looking for
			percent-=10;
		}
		if(!mate.getSeekGender().equals(user.getMyGender())){ 	//if you aren't what the mate is looking for
			percent-=10;
		}
		if(!mate.getCleanliness().equals(user.getCleanliness())){	//if the mate is more dirty or clean than you
			percent-=10;
		}
		if(!mate.getInOut().equals(user.getInOut())){		//if the mate is going to be gone more or less than you plan to be gone
			percent-=5;
		}
		if(!mate.getPersonality().equals(user.getPersonality())){
			percent-=5;
		}
		if(!mate.getNoise().equals(user.getNoise())){
			percent-=10;
		}
		if(!mate.getSport().equals(user.getSport())){
			percent-=5;
		}
		if(!mate.getMammal().equals(user.getMammal())){
			percent-=7;
		}
		if(!mate.getReptile().equals(user.getReptile())){
			percent-=8;
		}
		if(!mate.getSleep().equals(user.getSleep())){
			percent-=10;
		}
		if(!mate.getWake().equals(user.getWake())){
			percent-=10;
		}
		return percent;
	}
	//iterate through all the users, compare with  and set the correct percentages
	public void setAllPercent(){
		try{
			makeThePeople(); 	//read everyone else's info from the file
			int i=0;
			while(i< (others.size())){
				others.get(i).setCompatiblePercent(getPercent(others.get(i))); 	//set the compatibility percent with the mate
				i++;
			}
		}catch(NullPointerException exc){
			
		}
	}
	
	//get the arraylists
	public ArrayList<User> getAllPeople(){
		return others;
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList getAllPeopleInfo(){
		return othersInfo;
	}
	
	//get a line from the array list
	public String getDisplayString(int index){
		try{
			return others.get(index).getUsername()+ " " + others.get(index).getCompatiblePercent()+"%";
		}catch(IndexOutOfBoundsException exc){
			return "Didn't work";
		}
	}
	
	@SuppressWarnings("unchecked")
	public void convertArrayList(){
		for(User use : others){		//for every user that isn't the one logged in
			use.addPercentToMap(use.getCompatiblePercent());	//add their match % to their info map
			othersInfo.add(use.getMap());								//add their info map to the array list
		}
	}
}
