package kr.ac.ajou.dsd.kda.util;

public class EnvVariables {

	public static String getImageDir() {
		String dataDir = System.getenv("$OPENSHIFT_DATA_DIR");
		if (dataDir == null) dataDir = "";
		dataDir += "images/";
		return dataDir;
	}
	
}
