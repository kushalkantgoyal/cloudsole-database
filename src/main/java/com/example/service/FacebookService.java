package com.example.service;

import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.DefaultJsonMapper;
import com.restfb.Facebook;
import com.restfb.FacebookClient;
import com.restfb.JsonMapper;
import com.restfb.Parameter;
import com.restfb.json.JsonArray;
import com.restfb.json.JsonObject;
import com.restfb.types.NamedFacebookType;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.Url;
import com.restfb.types.User;
import com.restfb.types.User.Education;
import com.restfb.types.User.Sport;
import com.restfb.types.User.Work;

@SuppressWarnings("deprecation")
public class FacebookService {
	
	private final FacebookClient facebookClient;
	private final static String AccessToken = "AAADPhmv3fagBAFzfe6xksCqH633cXYAtL8VZANWDNwENPFgumbfcxpmKvo7YujGs9Fe3Oi00goSMKrbRwfTFh2J7QbHZA5IltrTDs9rAZDZD";
	  /**
	   * Entry point. You must provide a single argument on the command line: a
	   * valid Graph API access token.
	   * 
	   * @param args
	   *          Command-line arguments.
	   * @throws IllegalArgumentException
	   *           If no command-line arguments are provided.
	   */
	
	
	  public static void main(String[] args) {
	   
	    new FacebookService(AccessToken).runEverything();
	  }

	  FacebookService(String accessToken) {
	    facebookClient = new DefaultFacebookClient(accessToken);
	  }

	  void runEverything() {
	    //fetchObject();
	    //fetchObjects();
	   // fetchObjectsAsJsonObject();
	   // fetchConnections();
	    //fetchDifferentDataTypesAsJsonObject();
	    //query();
	    //multiquery();
	    search();
	    //metadata();
	    //paging();
	    //selection();
	    //parameters();
	    //rawJsonResponse();
	  }

	  void fetchObject() {
	    out.println("* Fetching all my details objects *");

	    User user = facebookClient.fetchObject("me", User.class);
	   

	    out.println("User Name: 		" + user.getName());
	    out.println("User FirstName: 	" + user.getFirstName());
	    out.println("User Middle Name: 	" + user.getMiddleName());
	    out.println("User LastName: 	" + user.getLastName());
	    out.println("User BirthDay: 	" + user.getBirthday());
	    out.println("User Bio: 			" + user.getBio());
	    out.println("User Email: 		" + user.getEmail());
	    out.println("User Gender: 		" + user.getGender());
	    out.println("User Home Town:	" + user.getHometownName());
	    out.println("User Link: 		" + user.getLink());
	    out.println("User Locale: 		" + user.getLocale());
	    out.println("User Political: 	" + user.getPolitical());
	    out.println("User Quotes: 		" + user.getQuotes());
	    out.println("User Relationship Status: " + user.getRelationshipStatus());
	    out.println("User Religion: 	" + user.getReligion());
	    out.println("User Third Party URL: " + user.getThirdPartyId());
	    out.println("User Type: 		" + user.getType());
	    out.println("User Website: 		" + user.getWebsite());
	    out.println("User TimeZone: 	" + user.getTimezone());
	    out.println("User Interested In:" + user.getInterestedIn());
	    
	    List<Education> edu = user.getEducation();
	    
	    for (Education ed : edu)
	    {
	    	out.println("User Education - School: " +  ed.getSchool().getName() + " Degree: " + ed.getDegree());
	    }
	    List<Work> workd = user.getWork();
	    for (Work wk : workd)
	    {
	    	out.println("User Employer : " + wk.getEmployer().getName());
	    }
	    List<Sport> sport = user.getSports();
	    for (Sport sp : sport)
	    {
	    	out.println("User Sport: " + sp.getName());
	    }
	    List<NamedFacebookType> lang = user.getLanguages();
	    for (NamedFacebookType l : lang)
	    {
	    	out.println("User Language: " + l.getName());
	    }
	   
	    List<NamedFacebookType> favAthletes = user.getFavoriteAthletes();
	    for (NamedFacebookType fa : favAthletes)
	    {
	    	out.println("User Fav Athletes: " + fa.getName());
	    }
	    List<NamedFacebookType> favTeams = user.getFavoriteTeams();
	    for (NamedFacebookType ft : favTeams)
	    {
	    	out.println("User Fav Teams: " + ft.getName());
	    }
	   
	    out.println("User Significant Other: " + user.getSignificantOther().getName() + " ID: " + user.getSignificantOther().getId());
	  
	     Page page = facebookClient.fetchObject("RocketLawyer", Page.class);
	     out.println("Page likes: " + page.getLikes());
	     out.println("Page Username: " + page.getUsername());
	     out.println("Page Talked About: " + page.getTalkingAboutCount());
	     
	    
	  }

	  void fetchObjectsAsJsonObject() {
	    out.println("* Fetching multiple objects at once as a JsonObject *");

	    List<String> ids = new ArrayList<String>();
	    ids.add("marise.michels");
	    ids.add("http://techcrunch.com/2012/10/30/george-lucas-i-sold-lucasfilm-to-disney-to-protect-it/");

	    // Make the API call
	    JsonObject results = facebookClient.fetchObjects(ids, JsonObject.class);

	    // Pull out JSON data by key and map each type by hand.
	    JsonMapper jsonMapper = new DefaultJsonMapper();
	    User user = jsonMapper.toJavaObject(results.getString("marise.michels"), User.class);
	    Url url = jsonMapper.toJavaObject(results.getString("http://techcrunch.com/2012/10/30/george-lucas-i-sold-lucasfilm-to-disney-to-protect-it/"), Url.class);

	    out.println("User is " + user);
	    out.println("URL is " + url);
	  }

	  void fetchObjects() {
	    out.println("* Fetching multiple objects at once *");

	    FetchObjectsResults fetchObjectsResults =
	        facebookClient.fetchObjects(Arrays.asList("me", "cocacola"), FetchObjectsResults.class);

	    out.println("User name: " + fetchObjectsResults.me.getName());
	    out.println("Page likes: " + fetchObjectsResults.page.getLikes());
	    
	  }

	  void fetchDifferentDataTypesAsJsonObject() {
	    out.println("* Fetching different types of data as JsonObject *");

	    JsonObject tmichels = facebookClient.fetchObject("thys.michels", JsonObject.class);
	    out.println(tmichels.getString("id"));

	    JsonObject photosConnection = facebookClient.fetchObject("me/photos", JsonObject.class);
	    JsonArray photosConnectionData = photosConnection.getJsonArray("data");
	    LinkedList<String> photoURL = new LinkedList<String>();
	    	
	    if (photosConnectionData.length() > 0) {
	    for (int k =0; k < photosConnectionData.length(); k++)
	    {
	    	photoURL.add(photosConnectionData.getJsonObject(k).getString("source"));
	    	out.println(photosConnectionData.getJsonObject(k).getString("source"));
	    }
	    }

	    String query = "SELECT uid, name FROM user WHERE uid=577120545";
	    List<JsonObject> queryResults = facebookClient.executeQuery(query, JsonObject.class);

	    if (queryResults.size() > 0)
	      out.println(queryResults.get(0).getString("name"));
	  }

	  /**
	   * Holds results from a "fetchObjects" call.
	   */
	  public static class FetchObjectsResults {
	    @Facebook
	    User me;

	    @Facebook(value = "cocacola")
	    Page page;
	  }

	  void fetchConnections() {
	    out.println("* Fetching connections *");

	    Connection<User> myFriends = facebookClient.fetchConnection("me/friends", User.class);
	    Connection<Post> myFeed = facebookClient.fetchConnection("me/feed", Post.class);

	    out.println("Count of my friends: " + myFriends.getData().size());

	    if (myFeed.getData().size() > 0)
	      out.println("First item in my feed: " + myFeed.getData().get(1).getMessage());
	    
	    for (int k = 0; k < myFriends.getData().size(); k++)
	    {
	    	out.println(myFriends.getData().get(k).getName());
	    }
	  }

	  void query() {
	    out.println("* FQL Query *");

	    List<FqlUser> users =
	        facebookClient.executeQuery("SELECT uid, name FROM user WHERE uid=220439 or uid=7901103", FqlUser.class);

	    out.println("User: " + users);
	  }

	  void multiquery() {
	    out.println("* FQL Multiquery *");

	    Map<String, String> queries = new HashMap<String, String>();
	    queries.put("users", "SELECT uid, name FROM user WHERE uid=220439 OR uid=7901103");
	    queries.put("likers", "SELECT user_id FROM like WHERE object_id=122788341354");

	    MultiqueryResults multiqueryResults = facebookClient.executeMultiquery(queries, MultiqueryResults.class);

	    out.println("Users: " + multiqueryResults.users);
	    out.println("People who liked: " + multiqueryResults.likers);
	  }

	  /**
	   * Holds results from an "executeQuery" call.
	   * <p>
	   * Be aware that FQL fields don't always map to Graph API Object fields.
	   */
	  public static class FqlUser {
	    @Facebook
	    String uid;

	    @Facebook
	    String name;

	    @Override
	    public String toString() {
	      return format("%s (%s)", name, uid);
	    }
	  }

	  /**
	   * Holds results from an "executeQuery" call.
	   * <p>
	   * Be aware that FQL fields don't always map to Graph API Object fields.
	   */
	  public static class FqlLiker {
	    @Facebook("user_id")
	    String userId;

	    @Override
	    public String toString() {
	      return userId;
	    }
	  }

	  /**
	   * Holds results from a "multiquery" call.
	   */
	  public static class MultiqueryResults {
	    @Facebook
	    List<FqlUser> users;

	    @Facebook
	    List<FqlLiker> likers;
	  }

	  void search() {
	    out.println("* Searching connections *");

	    Connection<Post> publicSearch =
	        facebookClient.fetchConnection("search", Post.class, Parameter.with("q", "South Africa"),
	          Parameter.with("type", "post"));

	    Connection<User> targetedSearch =
	        facebookClient.fetchConnection("me/home", User.class, Parameter.with("q", "Irene"),
	          Parameter.with("type", "user"));

	    if (publicSearch.getData().size() > 0)
	    for (int k =0; k<publicSearch.getData().size();k++)
	      out.println("Public search: " + publicSearch.getData().get(k).getMessage());

	    out.println("Posts on my wall by friends named Irene: " + targetedSearch.getData().size());
	  }

	  void metadata() {
	    out.println("* Metadata *");

	    User userWithMetadata = facebookClient.fetchObject("me", User.class, Parameter.with("metadata", 1));

	    out.println("User metadata: has albums? " + userWithMetadata.getMetadata().getConnections().hasAlbums());
	  }

	  void paging() {
	    out.println("* Paging support *");

	    Connection<User> myFriends = facebookClient.fetchConnection("me/friends", User.class);
	    Connection<Post> myFeed = facebookClient.fetchConnection("me/feed", Post.class, Parameter.with("limit", 100));

	    out.println("Count of my friends: " + myFriends.getData().size());

	    if (myFeed.getData().size() > 0)
	      out.println("First item in my feed: " + myFeed.getData().get(0));

	    for (List<Post> myFeedConnectionPage : myFeed)
	      for (Post post : myFeedConnectionPage)
	        out.println("Post from my feed: " + post);
	  }

	  void selection() {
	    out.println("* Selecting specific fields *");

	    User user = facebookClient.fetchObject("me", User.class, Parameter.with("fields", "id,name"));

	    out.println("User name: " + user.getName());
	  }

	  void parameters() {
	    out.println("* Parameter support *");

	    Date oneWeekAgo = new Date(currentTimeMillis() - 1000L * 60L * 60L * 24L * 7L);

	    Connection<Post> filteredFeed =
	        facebookClient.fetchConnection("me/feed", Post.class, Parameter.with("limit", 3),
	          Parameter.with("until", "yesterday"), Parameter.with("since", oneWeekAgo));

	    out.println("Filtered feed count: " + filteredFeed.getData().size());
	  }

	  void rawJsonResponse() {
	    out.println("* Raw JSON *");
	    out.println("User object JSON: " + facebookClient.fetchObject("me", String.class));
	  }

}
