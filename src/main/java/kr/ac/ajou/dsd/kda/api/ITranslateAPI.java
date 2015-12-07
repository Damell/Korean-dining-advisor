package kr.ac.ajou.dsd.kda.api;

/**
 * @author Jae wook
 * Interface that can help translation and transliteration  
 */
public interface ITranslateAPI {

	
	/**
	 * korean name translate to English name 
	 * @param koranName saved in Meal
	 * @return String EnglishName translated by bing API
	 */
	public String translateToEng(String koreanName);
	
	/**
	 * korean name transliterate to English name 
	 * @param koranName saved in Meal
	 * @return String EnglishName transliterate by glosbeAPI
	 */
	public String transliteratToEng(String koreanName);
	
	
}
