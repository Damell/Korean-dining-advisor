package kr.ac.ajou.dsd.kda.repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import kr.ac.ajou.dsd.kda.model.IMeal;

public interface IMealRepository {
	public IMeal getMeal(UUID uuid);
	public Map<UUID, IMeal> search(String query);

	public void add(IMeal meal);
	public void update(IMeal meal);

	public void delete(UUID uuid);
	public Collection<? extends IMeal> findInAllNames(String query);
	public List<IMeal> getall();

}
