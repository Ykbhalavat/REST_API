
// created by Yash Bhalavat
// This program parses the movie api json string and then puts it inside a IRC Server bot.
//version 1.0 

import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.lang.*;
import com.google.gson.JsonObject;

public class parseAPI {
	// this function gets the movie information from the URL
	public static String getmovie(String userinput) 
	{
		// TODO Auto-generated method stub
		String myAPIurl = "http://www.omdbapi.com/?t=";
		String result = " ";
		String myApiToken = "&apikey=2edbc671 ";
		String movieURL = myAPIurl + userinput  + myApiToken;//myAPIurl +  myApiToken;
		 // adding the tittle to the URL
		URL url = null;  
		try {
			url = new URL(movieURL);  // creating a URL object
		} catch (MalformedURLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpURLConnection conn = null;
		try {
			// checking for http connection
			conn = (HttpURLConnection) url.openConnection();
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.setRequestMethod("GET");  // getting the information from the URL
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader rd = null;
		try { rd = new BufferedReader  // buffer reader reads the information
				( new InputStreamReader(conn.getInputStream()));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		// Convert rd variable from BufferReader to String and store in variable called
		// result.
		try {
			result = rd.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Function that will parse your JSON
		String parse = parseJsonFunction(result); 
		// this function will return the infromation from the function
		return parse;

	}
	
	public static String parseJsonFunction(String json) 
	{   //creating a json  object 
		JsonObject object = new JsonParser().parse(json).getAsJsonObject();
		// getting the string from the object 
		String title = object.get("Title").getAsString();
		String released = object.get("Released").getAsString();
		String awards = object.get("Awards").getAsString();
		String actors = object.get("Actors").getAsString();
		String director = object.get("Director").getAsString();
		// joining all the string
		String total = "The movie name is " + title + " it released in " + released + " The actors that worked were "
		+ actors + " it was directed by " + director  + " and " + awards;
		// returing total 
		return total;
	}	
	
	}

