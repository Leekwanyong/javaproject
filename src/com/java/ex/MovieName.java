package com.java.ex;

import java.sql.Timestamp;

public class MovieName {
	private String movietitle;
	private String movierank;
	private String movieimg;
	private String moviedate;
	
	public MovieName() {
		
	}
	public MovieName(String movietitle, String movierank, String movieimg, String moviedate) {
		this.movietitle = movietitle;
		this.movierank = movierank;
		this.movieimg = movieimg;
		this.moviedate = moviedate;
		
	}
	public String getMovietitle() {
		return movietitle;
	}
	public void setMovietitle(String movietitle) {
		this.movietitle = movietitle;
	}
	public String getMovierank() {
		return movierank;
	}
	public void setMovierank(String movierank) {
		this.movierank = movierank;
	}
	public String getMovieimg() {
		return movieimg;
	}
	public void setMovieimg(String movieimg) {
		this.movieimg = movieimg;
	}
	public String getMoviedate() {
		return moviedate;
	}
	public void setMoviedate(String moviedate) {
		this.moviedate = moviedate;
	}
	
	
}
