package kr.ac.ajou.dsd.kda.util;

/**
 * @author Daniel Chabr
 * Utility class for accessing environment variables on Openshift but returns valid value even on localhost
 */
public class EnvVariables {

	public static String getImageDir() {
		String dataDir = System.getenv("$OPENSHIFT_DATA_DIR");
		if (dataDir == null) dataDir = "";
		dataDir += "images/";
		return dataDir;
	}
	
}
