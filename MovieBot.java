import java.io.IOException;
import org.jibble.pircbot.*;

public class MovieBot {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		movieserver bot = new movieserver();     // creating an object from the function
		bot.setVerbose(true);        // this would activate 
		try {
			bot.connect("irc.freenode.net");    // connecting the bot 
		}
		 catch (Exception e) {

				System.out.println("unable to connect " + e);    // if not able to print the message
				return;
			}
		bot.joinChannel("#GUJJUConnect");    // connecting to this channel 
	}
}
class movieserver extends PircBot
{
	public movieserver() {
		
		this.setName("apnatimebot");  // name of the bot 
	}	
		@Override  // overriding the message using onMessage method. 
		public void onMessage(String channel, String sender, String login, String hostname, String message) {
			if (message.contains("tittle ")) 
			{  // if the message contains weather then go inside the if statement.
				 String name = message.substring(7, message.length() - 1); // reading the string from 7 to n-1
				 String set = parseAPI.getmovie(name);
				 sendAction(channel, set);  // this would send action to bot and print the information.
				 sendAction(channel, " Thank you for using the API and Server");
			}		
	}
}