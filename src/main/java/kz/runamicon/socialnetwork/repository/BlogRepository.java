package kz.runamicon.socialnetwork.repository;

import kz.runamicon.socialnetwork.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
