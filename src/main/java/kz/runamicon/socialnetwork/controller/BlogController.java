package kz.runamicon.socialnetwork.controller;

import kz.runamicon.socialnetwork.entity.Blog;
import kz.runamicon.socialnetwork.service.blog.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
    private final BlogService service;

    public BlogController(BlogService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        Blog blog = service.findById(id);
        return ResponseEntity.ok(blog);
    }

    @PostMapping
    public ResponseEntity<Void> saveBlog(@RequestBody Blog blog) {
        service.saveBlog(blog);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
