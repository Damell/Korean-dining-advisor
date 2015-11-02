package kr.ac.ajou.dsd.kda.model;

public class Rating {
	
	private int numUsersRated;
	private int rating;
	
	public Rating () {
		this.rating = 0;
		this.numUsersRated = 0;
	}
	
	public int getRating() {
		return rating;
	}
	public void setRating(int ratingNew) {
		if (ratingNew > 5 || ratingNew < 0) return;
		this.rating = (rating * numUsersRated + ratingNew) / (numUsersRated + 1);
		this.numUsersRated++;
	}
	
}
