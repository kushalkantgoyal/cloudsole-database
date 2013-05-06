package com.example.service;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import twitter4j.AsyncTwitter;
import twitter4j.AsyncTwitterFactory;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterAdapter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterListener;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

@Controller
@RequestMapping("/twitter")
public class TwitterService {
	
	public static Twitter config()
	{
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("6D135COp4NBFD2yJjPljA")
		  .setOAuthConsumerSecret("4jvidAM9QN46sBG6fzxqgR3wpo4FLZTZl9naq1YUo")
		  .setOAuthAccessToken("21381980-h2to4eYC46npt4nJsRI7L312ctTf8mkubSlQ84WY")
		  .setOAuthAccessTokenSecret("L4b8hv58bDXUTTg01lPLDy2qaP4vOGANGclB6eQct2o");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		return twitter;
	}
	
	public static void main(String[] args) throws TwitterException {
		getTimeline();
		post();
	}

	public static void post() throws TwitterException
	{
		// The factory instance is re-useable and thread safe.
	    //twitter = TwitterFactory.getSingleton();
	    Status status = config().updateStatus("Testing out Twitter4j");
	    System.out.println("Successfully updated the status to [" + status.getText() + "].");
	}
	public static void getTimeline() throws TwitterException
	{
		 // The factory instance is re-useable and thread safe.
	    //twitter = TwitterFactory.getSingleton();
	    List<Status> statuses = config().getHomeTimeline();
	    System.out.println("Showing home timeline.");
	    for (Status status : statuses) {
	        System.out.println(status.getUser().getName() + ":" +
	                           status.getText());
	    }
		//return statuses;
	}
	
	public static void directMessage()
	{
		 // The factory instance is re-useable and thread safe.
	    Twitter sender = TwitterFactory.getSingleton();
	   // DirectMessage message = sender.sendDirectMessage(recipientId, message);
	   // System.out.println("Sent: " message.getText() + " to @" + message.getRecipientScreenName());
	}
	
	public static void searchTweet() throws TwitterException
	{
		// The factory instance is re-useable and thread safe.
	    Twitter twitter = TwitterFactory.getSingleton();
	    Query query = new Query("source:twitter4j salesforce");
	    QueryResult result = twitter.search(query);
	    for (Status status : result.getTweets()) {
	        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
	    }
	}
	
	public static void asyncTwitter()
	{		
	    // The factory instance is re-useable and thread safe.
	    AsyncTwitterFactory factory = new AsyncTwitterFactory();
	    AsyncTwitter asyncTwitter = factory.getInstance();
	    asyncTwitter.updateStatus("");
	}
	
	public static void streamTwitter()
	{
		StatusListener listener = new StatusListener(){
	        public void onStatus(Status status) {
	            System.out.println(status.getUser().getName() + " : " + status.getText());
	        }
	        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
	        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
	        public void onException(Exception ex) {
	            ex.printStackTrace();
	        }
			@Override
			public void onScrubGeo(long arg0, long arg1) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub
				
			}
	    };
		TwitterStreamFactory twitterStream = new TwitterStreamFactory();
	    // sample() method internally creates a thread which manipulates TwitterStream and calls these adequate listener methods continuously.
	    //twitterStream.;
	}
	
}
