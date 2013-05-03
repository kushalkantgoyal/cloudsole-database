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
import com.restfb.batch.BatchRequest;
import com.restfb.batch.BatchRequest.BatchRequestBuilder;
import com.restfb.batch.BatchResponse;
import com.restfb.json.JsonArray;
import com.restfb.json.JsonObject;
import com.restfb.types.NamedFacebookType;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.User;
import com.restfb.types.User.Education;
import com.restfb.types.User.Sport;
import com.restfb.types.User.Work;

@SuppressWarnings("deprecation")
public class FacebookService {
	
	private final FacebookClient facebookClient;
	private final static String AccessToken = "BAAHTNvXJOfwBAEKvuAY3xzeF6UfKLWOxDvaFGlknAKPtWYAvuquuZBdqwx97E3GOHCtmHgMCsAVxDLgr9zDnebJFfZCIzp3ZCEMXmsyvb7ayXvdo9bM";

	/**
	   * Entry point. You must provide a single argument on the command line: a
	   * valid Graph API access token.
	   * 
	   * @param args
	   *          Command-line arguments.
	   * @throws IllegalArgumentException
	   *           If no command-line arguments are provided.
	   */
		
	 public void batch()
	 {
		// The Batch API is great if you have multiple operations you'd like to
		// perform in one server trip. Let's build a batch with three GET requests and
		// one POST request here:
		
		BatchRequest meRequest = new BatchRequestBuilder("me").build();
		BatchRequest badRequest = new BatchRequestBuilder("this-is-a-bad-request/xxx").build();
		BatchRequest m83musicRequest = new BatchRequestBuilder("m83music/feed")
		  .parameters(Parameter.with("limit", 5)).build();
		BatchRequest postRequest = new BatchRequestBuilder("me/feed")
		  .method("POST")
		  .body(Parameter.with("message", "Testing!")).build();

		// ...and execute the batch.

		List<BatchResponse> batchResponses =
		  facebookClient.executeBatch(meRequest, badRequest, m83musicRequest, postRequest);

		// Responses are ordered to match up with their corresponding requests.

		BatchResponse meResponse = batchResponses.get(0);
		BatchResponse badResponse = batchResponses.get(1);
		BatchResponse m83musicResponse = batchResponses.get(2);
		BatchResponse postResponse = batchResponses.get(3);

		// Since batches can have heterogenous response types, it's up to you
		// to parse the JSON into Java objects yourself. Luckily RestFB has some built-in
		// support to help you with this.

		JsonMapper jsonMapper = new DefaultJsonMapper();

		// Here we marshal to the built-in User type.

		User me = jsonMapper.toJavaObject(meResponse.getBody(), User.class);
		out.println(me);

		// To detect errors, check the HTTP response code.

		if(badResponse.getCode() != 200)
		  out.println("Batch request failed: " + badResponse);

		// You can pull out connection data...

		out.println("M83's feed follows");

		Connection<Post> m83musicPosts =
		  new Connection<Post>(facebookClient, m83musicResponse.getBody(), Post.class);

		for (List<Post> m83musicPostsConnectionPage : m83musicPosts)
		  for (Post post : m83musicPostsConnectionPage)
		    out.println(post);

		// ...or do whatever you'd like with the raw JSON.

		out.println(postResponse.getBody());
	 }
	
	  public static void main(String[] args) {
	   
	    new FacebookService(AccessToken).runEverything();
	  }

	  FacebookService(String accessToken) {
	    facebookClient = new DefaultFacebookClient(accessToken);
	  }

	  void runEverything() {
	    //fetchObject();
	    //fetchObjects();
	    fetchObjectsAsJsonObject();
	   // fetchConnections();
	    //fetchDifferentDataTypesAsJsonObject();
	    //query();
	    //multiquery();
	    //search();
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
	    ids.add("charley.moore");
	   
	    // Make the API call
	    JsonObject results = facebookClient.fetchObjects(ids, JsonObject.class);

	    // Pull out JSON data by key and map each type by hand.
	    JsonMapper jsonMapper = new DefaultJsonMapper();
	    User user = jsonMapper.toJavaObject(results.getString("charley.moore"), User.class);
	    
	    out.println("User is " + user);
	  
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
	        facebookClient.executeQuery("SELECT uid, name FROM user WHERE name=charley.moore", FqlUser.class);

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

	  //  Connection<Post> publicSearch =
	   //     facebookClient.fetchConnection("search", Post.class, Parameter.with("q", "South Africa"),
	    //      Parameter.with("type", "post"));

	    Connection<User> targetedSearch =
	        facebookClient.fetchConnection("me/home", User.class, Parameter.with("q", "irene.haque"),
	          Parameter.with("type", "user"));

	    if (targetedSearch.getData().size() > 0)
	    for (int k =0; k<targetedSearch.getData().size();k++)
	      out.println("Public search: " + targetedSearch.getData().get(k));

	    //out.println("Posts on my wall by friends named Irene: " + targetedSearch.getData().size());
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
