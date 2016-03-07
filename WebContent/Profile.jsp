<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Answer the questions</title>
<link rel="stylesheet" href="style.css">    
</head>
<body>
<% 
String  sample  = (String) session.getAttribute("username");        
%><div class="mainContent">
<div id="helloUser">
	<div style="color:#800000"><h1>Hello <%= sample %></h1></div></div>
	<h2>There are a few questions you need to answer before we can accurately<br>
			match you with other room mates</h2>
			
	<form action="question" method="post">
	
	<input type="hidden"name="username" value="<%out.print(sample);%>"/><!-- I'm sending the username to the servlet so it can be used as an id in the text file-->
		<b>Your real name</b> <input type="text" name="realName" value="full name" /><br>
		
		<b>Your email address</b> <input type="text" name="email" value="sample@email.com" /><br>	
			
		<b>How old are you?</b> <input type="text" name="age" /><br>
		
		<br> <b style="padding-left: 5px">I'm a... wanting to room with a</b><br> <b>male</b><input
			type="radio" name="myGender" value="male" checked="checked"/> <b
			style="padding-left: 35px">male</b><input type="radio"
			name="otherGender" value="male" checked="checked"/><br> <b>female</b><input
			type="radio" name="myGender" value="female" /> <b
			style="padding-left: 20px">female</b><input type="radio"
			name="otherGender" value="female" /><br>


		<p>My cleanliness is</p>
		<select name="dirtiness">
			<option value="verymessy" selected>Messy slob</option>
			<option value="messy">Lazy but I clean up occasionally</option>
			<option value="clean">I clean up after myself</option>
			<option value="veryclean">Total neat freak</option>
		</select>
		
		<p>I leave my living quarters</p>
		<select name="availability">
			<option value="alwaysin" selected>Never leave</option>
			<option value="in">I only leave when I need to</option>
			<option value="inout">About half the day</option>
			<option value="out">Mostly always leave</option>
			<option value="alwaysout">All day usually</option>
		</select>
		
		<p>I am</p>
		<input type="radio" name="personality" value="extroverted" checked="checked">More extroverted<br>
		<input type="radio" name="personality" value="introverted">More introverted<br> 


		<p>Do you like loud noises?</p>
		<p>I am</p>
		<input type="radio" name="sound" value="loud" checked="checked">I like loud entertainment<br>
		<input type="radio" name="sound" value="noisy">I like some noise<br> 
		<input type="radio" name="sound" value="quiet">I am always quiet<br> 
		
		<!-- change this to radio buttons or drop down menu -->
		<p>Do you want to play games or sports with your room mate?</p>
		<input type="radio" name="game" value="noGame" checked="checked">No games<br>
		<input type="radio" name="game" value="videoGame">Non-athletic games like video games or cards<br> 
		<input type="radio" name="game" value="athGame">Athletic games like basketball<br> 
		<input type="radio" name="game" value="allGame">Any kind of game<br> 
		
		<!-- change this to radio buttons or drop down menu -->
		<p>I want to live with these pets</p>
		<input type="radio" name="mammal" value="dogCat" checked="checked">Dog/Cat<br>
		<input type="radio" name="mammal" value="noDogCat">No Dog/Cat<br><br>
		
		<input type="radio" name="reptile" value="snakeSpider"checked="checked">Snake/Spider<br>
		<input type="radio" name="reptile" value="noSnakeSpider">No Snake/Spiders<br>
		
		<p>I usually go to sleep around this time</p>
		<input type="radio" name="night" value="before9" checked="checked">Before 9pm<br>
		<input type="radio" name="night" value="around10">Around 10pm<br> 
		<input type="radio" name="night" value="around11">Around 11pm<br> 
		<input type="radio" name="night" value="around12">Around midnight<br> 
		<input type="radio" name="night" value="after12">After midnight<br> 
		
		<p>I usually wake up around this time</p>
		<input type="radio" name="morning" value="before6" checked="checked">Before 6am<br>
		<input type="radio" name="morning" value="around7">Around 7am<br> 
		<input type="radio" name="morning" value="around8">Around 8am<br> 
		<input type="radio" name="morning" value="around9">Around 9am<br> 
		<input type="radio" name="morning" value="after9">After 9am<br> 

		<input type="submit" value="Submit">

	</form>
    </div>
<br><br><br>
        </body>
</html>