package kz.runamicon.socialnetwork.repository;

import kz.runamicon.socialnetwork.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);

    @Query("UPDATE User u SET u.username = :username WHERE u.id = :id")
    @Modifying
    int updateUsername(Long id, String username);

    @Query("UPDATE User u SET u.email = :email WHERE u.id = :id")
    @Modifying
    int updateEmail(Long id, String email);

    @Query("UPDATE User u SET u.login = :login WHERE u.id = :id")
    @Modifying
    int updateLogin(Long id, String login);

    List<User> findAll();
}