package kr.ac.ajou.dsd.kda.model;

import java.util.Arrays;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Meal  {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column( columnDefinition = "BINARY(16)", length = 16 )
	private UUID id;
	
	@NotBlank(message = "koreanName must not be blank!")
	private String koreanName;
	
	@NotBlank(message = "englishName must not be blank!")
	private String englishName;
	
	@NotBlank(message = "transliteratedName must not be blank!")
	private String transliteratedName;
	
	private String description = "";
	private String[] ingredients = new String[]{""};
	private String[] category = new String[]{""};
	private String photoUrl = "";
	@Embedded
	private Rating rating = new Rating();
	private int viewNum = 0;
	private int spicyGrade = 0;
	
	protected Meal(){
	}
	
	public Meal(String koreanName, String englishName, String transliteratedName) {
		this(koreanName, englishName, transliteratedName, "", 
				new String[]{""}, new String[]{""}, new Rating(), 0, 0);
	}
	
	public Meal(String koreanName, String englishName, String transliteratedName, String description,
			String[] ingredients, String[] category, Rating rating, int viewNum, int spicyGrade) {
		super();	
		this.koreanName = koreanName;
		this.englishName = englishName;
		this.transliteratedName = transliteratedName;
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
	
	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(category);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((photoUrl == null) ? 0 : photoUrl.hashCode());
		result = prime * result + ((englishName == null) ? 0 : englishName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(ingredients);
		result = prime * result + ((koreanName == null) ? 0 : koreanName.hashCode());
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
		if (!Arrays.equals(category, other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (photoUrl == null) {
			if (other.photoUrl != null)
				return false;
		} else if (!photoUrl.equals(other.photoUrl))
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
