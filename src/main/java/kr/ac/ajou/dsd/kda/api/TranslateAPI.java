package kr.ac.ajou.dsd.kda.api;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

import kr.ac.ajou.dsd.kda.api.model.Transliteration;

@Service
public class TranslateAPI implements ITranslateAPI {
	
	@Override
	public String translateToEng(String koreanName) {
		
		Translate.setClientId("dsd_client");
		Translate.setClientSecret("vcMYacQdddTLuve0hn2jBBiAUTwcHVyyngj+DOE+1Ak=");
		
		
		String EnglishName;
		try {
			EnglishName = Translate.execute(koreanName, Language.KOREAN, Language.ENGLISH);
			return EnglishName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}


	@Override
	public String transliteratToEng(String koreanName) {
		
		RestTemplate rt = new RestTemplate();
		
		Transliteration trans = new Transliteration();
		
		
		
		trans = rt.getForObject("https://glosbe.com/transliteration/api?from=Hangul&dest=Latin&text={koreanName}&format=json", Transliteration.class, koreanName);
		
		return trans.getText();
		
	}

}
