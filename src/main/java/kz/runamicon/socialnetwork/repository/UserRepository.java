package kz.runamicon.socialnetwork.repository;

import kz.runamicon.socialnetwork.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);

    @Modifying
    @Query("UPDATE User u SET u.username = :username WHERE u.id = :id")
    int updateUsername(Long id, String username);
}