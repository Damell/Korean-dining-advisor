package kr.ac.ajou.dsd.kda.model;

import java.util.UUID;

public class Meal implements IMeal {
	
	static int count = 0;
	
	private int mealNum;
	private UUID mealId;
	private String koreanName;
	private String translatedName;
	private String transliteratedName;
	private String description;
	private String[] ingredients;
	
	private byte[] mealPic;
	

	private int viewNum;
	private int spicyGrade;
	
	{
		++count;
		mealNum = count;
		
	}
	
	public Meal() {
		
		
	}
	
	public Meal(String koreanName, String translatedName, String transliteratedName, String description,
			String[] ingredients, byte[] mealPic, int viewNum, int spicyGrade) {
		super();
		this.koreanName = koreanName;
		this.translatedName = translatedName;
		this.transliteratedName = transliteratedName;
		this.description = description;
		this.ingredients = ingredients;
		this.mealPic = mealPic;
		this.viewNum = viewNum;
		this.spicyGrade = spicyGrade;
		this.mealId = UUID.randomUUID();
	}
	
	
	public int getMealNum() {
		return mealNum;
	}
	
	public void setMealNum(int mealId) {
		this.mealNum = mealNum;
	}
	
	public String getKoreanName() {
		return koreanName;
	}
	
	public void setKoreanName(String koreanName) {
		this.koreanName = koreanName;
	}
	
	public String getTranslatedName() {
		return translatedName;
	}
	
	public void setTranslatedName(String translatedName) {
		this.translatedName = translatedName;
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

	public static int getCount() {
		return count;
	}


	public static void setCount(int count) {
		Meal.count = count;
	}

	public UUID getMealId() {
		return mealId;
	}

	public void setMealId(UUID mealId) {
		this.mealId = mealId;
	}

	
	

}
