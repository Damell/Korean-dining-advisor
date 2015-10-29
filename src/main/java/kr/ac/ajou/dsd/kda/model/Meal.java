package kr.ac.ajou.dsd.kda.model;

import java.util.UUID;

public class Meal implements IMeal{
	final private UUID uuid = UUID.randomUUID();
	
	@Override
	public UUID getUUID() {
		return uuid;
	}

}
