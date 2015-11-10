package kr.ac.ajou.dsd.kda.model;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Embeddable
public class Rating {
	
	private int numUsersRated;
	private int rating;
	
	public Rating () {
		this.rating = 0;
		this.numUsersRated = 0;
	}
	
	public Rating(int rating){
		setRating(rating);
	}
	
	@JsonValue
	public int getRating() {
		return rating;
	}
	@JsonCreator
	public void setRating(int ratingNew) {
		if (ratingNew > 5 || ratingNew < 0) return;
		this.rating = (rating * numUsersRated + ratingNew) / (numUsersRated + 1);
		this.numUsersRated++;
	}
	
}
