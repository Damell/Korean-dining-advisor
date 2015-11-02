package kr.ac.ajou.dsd.kda.model;

import java.util.List;
import java.util.UUID;

public class Meal  {
	
	
	private UUID id;
	private String koreanName;
	private String englishName;
	private String transliteratedName;
	private String description;
	private String[] ingredients;
	private List<Category> category;
	
	private byte[] mealPic;
	
	private Rating rating;
	private int viewNum;
	private int spicyGrade;
	
	
	public Meal() {
		
		
	}
	
	public Meal(String koreanName, String englishName, String transliteratedName, String description,
			String[] ingredients, byte[] mealPic, Rating rating, int viewNum, int spicyGrade) {
		super();
		this.koreanName = koreanName;
		this.englishName = englishName;
		this.transliteratedName = transliteratedName;
		this.description = description;
		this.ingredients = ingredients;
		this.mealPic = mealPic;
		this.rating = rating;
		this.viewNum = viewNum;
		this.spicyGrade = spicyGrade;
		this.id = UUID.randomUUID();
	}
	
	
	
	
	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public String getKoreanName() {
		return koreanName;
	}
	
	public void setKoreanName(String koreanName) {
		this.koreanName = koreanName;
	}
	
	public String getTransliteratedName() {
		return transliteratedName;
	}
	
	public void setTransliteratedName(String transliteratedName) {
		this.transliteratedName = transliteratedName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String[] getIngredients() {
		return ingredients;
	}
	
	public void setIngredients(String[] ingredients) {
		this.ingredients = ingredients;
	}
	
	public byte[] getMealPic() {
		return mealPic;
	}
	
	public void setMealPic(byte[] mealPic) {
		this.mealPic = mealPic;
	}
	
	public int getViewNum() {
		return viewNum;
	}
	
	public void setViewNum(int viewNum) {
		this.viewNum = viewNum;
	}
	
	public int getSpicyGrade() {
		return spicyGrade;
	}
	
	public void setSpicyGrade(int spicyGrade) {
		this.spicyGrade = spicyGrade;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID mealId) {
		this.id = mealId;
	}

	
	

}
