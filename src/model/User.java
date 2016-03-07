package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User {

	private String username;
	private String password;
	private String rePassword;
	
	private String ageStr;
	private int age=0;
	
	private String realName="name";
	private String email="email";
	
	private String myGender;
	private String seekGender;
	
	private String cleanliness;
	
	private String inOut;
	
	private String noise;
	
	private String sport;
	
	private String personality;
	
	private String mammal;
	private String reptile;
	
	private String sleep;
	private String wake;
	
	private int compatiblePercent;
	Map info;
	
	public User(){
		
	}
	
	public User(String username){
		this.username=username;
	}
	
	public User(String username, String password){
		this.username=username;
		this.password=password;
	}
	
	public User(ArrayList<String> param){
		info = new HashMap();
		setUsername(param.get(0));
		setAgeStr(param.get(1));
		setMyGender(param.get(2));
		setSeekGender(param.get(3));
		setCleanliness(param.get(4));
		setInOut(param.get(5));
		setPersonality(param.get(6));
		setNoise(param.get(7));
		setSport(param.get(8));
		setMammal(param.get(9));
		setReptile(param.get(10));
		setSleep(param.get(11));
		setWake(param.get(12));
		setRealName(param.get(13));
		setEmail(param.get(14));
		
		info.put("username",param.get(0));
		info.put("age",param.get(1));
		info.put("gender",param.get(2));
		info.put("seekGender",param.get(3));
		info.put("clean",param.get(4));
		info.put("inOut",param.get(5));
		info.put("personality",param.get(6));
		info.put("noise",param.get(7));
		info.put("sport",param.get(8));
		info.put("mammal",param.get(9));
		info.put("reptile",param.get(10));
		info.put("sleep",param.get(11));
		info.put("wake",param.get(12));
		info.put("realName",param.get(13));
		info.put("email",param.get(14));
	}
	public HashMap getMap(){
		return (HashMap) info;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return rePassword;
	}

	public void setRepassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public int getAge() {
		return age;
	}

	public void setAgeStr(String ageStr) {
		try{
			this.age = Integer.parseInt(ageStr);
		}catch(NumberFormatException exc){
			this.age=0;
		}
	}

	public String getMyGender() {
		return myGender;
	}

	public void setMyGender(String myGender) {
		this.myGender = myGender;
	}

	public String getSeekGender() {
		return seekGender;
	}

	public void setSeekGender(String seekGender) {
		this.seekGender = seekGender;
	}

	public int getCompatiblePercent() {
		return compatiblePercent;
	}

	public void setCompatiblePercent(int compatiblePercent) {
		this.compatiblePercent = compatiblePercent;
	}
	
	public void addPercentToMap(int percent){
		info.put("percent", String.valueOf(percent));
	}
	
	public String toString(){
		return realName + " is a " + compatiblePercent+"% match\n";
	}

	public String getCleanliness() {
		return cleanliness;
	}

	public void setCleanliness(String cleanliness) {
		this.cleanliness = cleanliness;
	}

	public String getInOut() {
		return inOut;
	}

	public void setInOut(String inOut) {
		this.inOut = inOut;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		
		if(!realName.equals("")){
			this.realName = realName;
		}else{
			this.realName=this.username;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(!email.equals("")){
			this.email = email;
		}
	}

	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public String getNoise() {
		return noise;
	}

	public void setNoise(String noise) {
		this.noise = noise;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getMammal() {
		return mammal;
	}

	public void setMammal(String mammal) {
		this.mammal = mammal;
	}

	public String getReptile() {
		return reptile;
	}

	public void setReptile(String reptile) {
		this.reptile = reptile;
	}

	public String getSleep() {
		return sleep;
	}

	public void setSleep(String sleep) {
		this.sleep = sleep;
	}

	public String getWake() {
		return wake;
	}

	public void setWake(String wake) {
		this.wake = wake;
	}

	
	

}
