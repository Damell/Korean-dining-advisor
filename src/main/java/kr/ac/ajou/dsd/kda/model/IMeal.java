package kr.ac.ajou.dsd.kda.model;

import java.util.UUID;

public interface IMeal {

	public static final int Stew = 1;
	public static final int Rice = 2;
	public static final int Noodle = 3;
	
	UUID getMealId();

}
