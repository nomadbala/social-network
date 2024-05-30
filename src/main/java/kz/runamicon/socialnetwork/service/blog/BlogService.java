package kz.runamicon.socialnetwork.service.blog;

import kz.runamicon.socialnetwork.entity.Blog;
import kz.runamicon.socialnetwork.repository.BlogRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "blog_cache")
public class BlogService {

    private final BlogRepository repository;

    public BlogService(BlogRepository repository) {
        this.repository = repository;
    }

    @Cacheable(value = "BlogService::findById", key = "#id")
    public Blog findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found with id: " + id));
    }

    @Caching(cacheable={
        @Cacheable(value = "BlogService::findById", key = "#blog.id")
    })
    public void saveBlog(Blog blog) {
        repository.save(blog);
    }
}
