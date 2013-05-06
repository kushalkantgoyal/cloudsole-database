package com.example.service;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.eclipse.egit.github.core.Authorization;
import org.eclipse.egit.github.core.Gist;
import org.eclipse.egit.github.core.GistFile;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryCommit;
import org.eclipse.egit.github.core.RepositoryId;
import org.eclipse.egit.github.core.service.CommitService;
import org.eclipse.egit.github.core.service.GistService;
import org.eclipse.egit.github.core.service.OAuthService;
import org.eclipse.egit.github.core.service.RepositoryService;

public class GitHubService {
	
	public void forkRepo() throws IOException
	{
		RepositoryService service = new RepositoryService();
		service.getClient().setCredentials("user", "passw0rd");
		RepositoryId toBeForked = new RepositoryId("rails", "rails");
		service.forkRepository(toBeForked);
	}
	
	public void showPageCommits()
	{
		final int size = 25;
		final RepositoryId repo = new RepositoryId("github", "hubot");
		final String message = "   {0} by {1} on {2}";
		final CommitService service = new CommitService();
		int pages = 1;
		for (Collection<RepositoryCommit> commits : service.pageCommits(repo,
				size)) {
			System.out.println("Commit Page " + pages++);
			for (RepositoryCommit commit : commits) {
				String sha = commit.getSha().substring(0, 7);
				String author = commit.getCommit().getAuthor().getName();
				Date date = commit.getCommit().getAuthor().getDate();
				System.out.println(MessageFormat.format(message, sha, author,
						date));
			}
		}
	}
	
	public void showUserRepositories() throws IOException
	{
		final String user = "defunkt";
		final String format = "{0}) {1}- created on {2}";
		int count = 1;
		RepositoryService service = new RepositoryService();
		for (Repository repo : service.getRepositories(user))
			System.out.println(MessageFormat.format(format, count++,
					repo.getName(), repo.getCreatedAt()));
	}
	
	public static void main(String[] args) throws IOException {
		
		
		OAuthService oauthService = new OAuthService();

		// Replace with actual login and password
		oauthService.getClient().setCredentials("thysmichels@gmail.com", "Andries7");

		// Create authorization with 'gist' scope only
		Authorization auth = new Authorization();
		auth.setScopes(Arrays.asList("gist"));
		auth = oauthService.createAuthorization(auth);

		// Create Gist service configured with OAuth2 token
		GistService gistService = new GistService();
		gistService.getClient().setOAuth2Token(auth.getToken());

		
		// Create Gist
		Gist gist = new Gist();
		gist.setPublic(false);
		gist.setDescription("Created using OAuth2 token via Java API");
		GistFile file = new GistFile();
		file.setContent("Gist!");
		file.setFilename("gist.txt");
		gist.setFiles(Collections.singletonMap(file.getFilename(), file));
		gist = gistService.createGist(gist);
		System.out.println("Created Gist at " + gist.getHtmlUrl());
	}
}
