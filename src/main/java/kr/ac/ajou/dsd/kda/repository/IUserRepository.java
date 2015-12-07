package kr.ac.ajou.dsd.kda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.ac.ajou.dsd.kda.model.User;

public interface IUserRepository extends JpaRepository<User, String> {

}
