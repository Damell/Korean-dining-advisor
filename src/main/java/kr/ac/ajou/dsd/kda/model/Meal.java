package kr.ac.ajou.dsd.kda.model;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.hibernate.validator.constraints.NotBlank;

public class Meal  {
	
	@NotBlank(message = "id must not be blank!")
	private UUID id;
	@NotBlank(message = "koreanName must not be blank!")
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
	
	public Meal(){
		
	}
	
	public Meal(String koreanName, String englishName, String transliteratedName) {
		super();
		this.id = UUID.randomUUID();
		this.koreanName = koreanName;
		this.englishName = englishName;
		this.transliteratedName = transliteratedName;
	}
	
	public Meal(String koreanName, String englishName, String transliteratedName, String description,
			String[] ingredients, byte[] mealPic, Rating rating, int viewNum, int spicyGrade) {
		this(koreanName, englishName, transliteratedName);
		
		this.description = description;
		this.ingredients = ingredients;
		this.mealPic = mealPic;
		this.rating = rating;
		this.viewNum = viewNum;
		this.spicyGrade = spicyGrade;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((englishName == null) ? 0 : englishName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(ingredients);
		result = prime * result + ((koreanName == null) ? 0 : koreanName.hashCode());
		result = prime * result + Arrays.hashCode(mealPic);
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + spicyGrade;
		result = prime * result + ((transliteratedName == null) ? 0 : transliteratedName.hashCode());
		result = prime * result + viewNum;
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
		Meal other = (Meal) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (englishName == null) {
			if (other.englishName != null)
				return false;
		} else if (!englishName.equals(other.englishName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(ingredients, other.ingredients))
			return false;
		if (koreanName == null) {
			if (other.koreanName != null)
				return false;
		} else if (!koreanName.equals(other.koreanName))
			return false;
		if (!Arrays.equals(mealPic, other.mealPic))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (spicyGrade != other.spicyGrade)
			return false;
		if (transliteratedName == null) {
			if (other.transliteratedName != null)
				return false;
		} else if (!transliteratedName.equals(other.transliteratedName))
			return false;
		if (viewNum != other.viewNum)
			return false;
		return true;
	}

}
