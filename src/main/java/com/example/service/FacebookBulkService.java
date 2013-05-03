package com.example.service;

import java.util.List;

import com.googlecode.batchfb.Batcher;
import com.googlecode.batchfb.FacebookBatcher;
import com.googlecode.batchfb.Later;
import com.googlecode.batchfb.PagedLater;

public class FacebookBulkService {

	private final static String AccessToken = "BAAHTNvXJOfwBAEKvuAY3xzeF6UfKLWOxDvaFGlknAKPtWYAvuquuZBdqwx97E3GOHCtmHgMCsAVxDLgr9zDnebJFfZCIzp3ZCEMXmsyvb7ayXvdo9bM";	
	//private final static String myId, bobsId = "123";
	public void runbatch()
	{
		Batcher batcher = new FacebookBatcher(AccessToken);

		//Later<User> me = batcher.graph("me", User.class);
		//Later<User> mark = batcher.graph("markzuckerberg", User.class);
		//Later<List<User>> myFriends = batcher.query(
		 //   "SELECT uid, first_name, pic_square FROM user WHERE uid IN" +
		  //  "(SELECT uid2 FROM friend WHERE uid1 = " + myId + ")", User.class);
		//Later<User> bob = batcher.queryFirst("SELECT timezone FROM user WHERE uid = " + bobsId, User.class);
		//PagedLater<Post> feed = batcher.paged("me/feed", Post.class);

		// No calls to Facebook have been made yet.  The following get() will execute the
		// whole batch as a single Facebook call.
		//String timezone = bob.get().timezone;

		// You can just get simple values forcing immediate execution of the batch at any time.
		//User ivan = batcher.graph("ivan", User.class).get();
	}

}
