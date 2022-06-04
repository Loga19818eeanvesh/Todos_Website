package start.springboot.web.springbootstartweb.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import start.springboot.web.springbootstartweb.model.User;


@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Integer> {
	Optional<User> findByUserName(String username);
}
