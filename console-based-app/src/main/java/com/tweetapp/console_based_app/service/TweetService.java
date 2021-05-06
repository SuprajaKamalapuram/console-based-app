package com.tweetapp.console_based_app.service;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;


import com.tweetapp.console_based_app.dao.TweetDao;
import com.tweetapp.console_based_app.entity.Tweet;

public class TweetService {
	
	TweetDao tweetDao = new TweetDao();
	
	public boolean createTweet(Tweet tweet) {
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		tweet.setCreated(date);
		tweetDao.createTweet(tweet);
		return true;
	}
	
	public boolean getAllTweets(){
		
		ResultSet rs = tweetDao.getAllTweets();
		try {
			if(rs.next()) {
				System.out.println(rs.getDate("created")+" "+rs.getString("tweet"));
			}else {
				System.out.println("No tweets found..");
			}
			while(rs.next()) {
				System.out.println(rs.getDate("created")+" "+rs.getString("tweet"));
			}
		}catch(Exception e) {
			System.out.println("Something went wrong. Please try again ");
		}
		return true;
	}
	
	public boolean getTweetsByUserId(int userId){
		
		ResultSet rs = tweetDao.getTweetsByUserId(userId);
		try {
			if(rs.next()) {
				System.out.println(rs.getDate("created")+" "+rs.getString("tweet"));
			}else {
				System.out.println("No tweets found..");
			}
			while(rs.next()) {
				System.out.println(rs.getDate("created")+" "+rs.getString("tweet"));
			}
		}catch(Exception e) {
			System.out.println("Something went wrong. Please try again ");
		}
		return true;
	}
}
