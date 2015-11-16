package kr.ac.ajou.dsd.kda.model;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Embeddable
public class Rating {
	
	private int numUsersRated;
	private int rating;
	
	public Rating () {
		this.rating = 0;
		this.numUsersRated = 0;
	}
	
	@JsonCreator
	public Rating(int rating){
		setRating(rating);
	}
	
	@JsonValue
	public int getRating() {
		return rating;
	}
	
	public void setRating(int ratingNew) {
		if (ratingNew > 5 || ratingNew < 0) return;
		this.numUsersRated++;
		this.rating = (rating * numUsersRated + ratingNew) / (numUsersRated + 1);
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numUsersRated;
		result = prime * result + rating;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rating other = (Rating) obj;
		if (numUsersRated != other.numUsersRated)
			return false;
		if (rating != other.rating)
			return false;
		return true;
	}
	
	
}
