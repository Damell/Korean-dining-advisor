package kr.ac.ajou.dsd.kda.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Meal  {
	
	//Id should be generated from hibernate
	@Id
	private UUID id;
	
	@NotBlank(message = "koreanName must not be blank!")
	private String koreanName;
	
	@NotBlank(message = "englishName must not be blank!")
	private String englishName;
	
	@NotBlank(message = "transliteratedName must not be blank!")
	private String transliteratedName;
	
	private String description;
	private String[] ingredients;
	private String[] category;
	private Rating rating;
	private int viewNum;
	private int spicyGrade;
	
	protected Meal(){
		this.id = UUID.randomUUID();
	}
	
	public Meal(String koreanName, String englishName, String transliteratedName) {
		this(koreanName, englishName, transliteratedName, "", 
				new String[]{""}, new String[]{""}, new Rating(), 0, 0);
	}
	
	public Meal(String koreanName, String englishName, String transliteratedName, String description,
			String[] ingredients, String[] category, Rating rating, int viewNum, int spicyGrade) {
		super();
		this.id = UUID.randomUUID();
		
		this.koreanName = koreanName;
		this.englishName = englishName;
		this.transliteratedName = transliteratedName;
		this.description = description;
		this.ingredients = ingredients;
		this.category = category;
		this.rating = rating;
		this.viewNum = viewNum;
		this.spicyGrade = spicyGrade;
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {
		this.id = id;
	}

	public String getKoreanName() {
		return koreanName;
	}

	public void setKoreanName(String koreanName) {
		this.koreanName = koreanName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
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

	public String[] getCategory() {
		return category;
	}

	public void setCategory(String[] category) {
		this.category = category;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
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

}
