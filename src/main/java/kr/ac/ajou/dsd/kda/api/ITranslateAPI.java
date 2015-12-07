package kr.ac.ajou.dsd.kda.api;

/**
 * @author Jae wook
 * Interface that can help translation and transliteration  
 */
public interface ITranslateAPI {

	public String translateToEng(String koreanName);
	public String transliteratToEng(String koreanName);
	
	
}
