package dev.christopherbell.blog;

import dev.christopherbell.blog.model.BlogResponse;
import dev.christopherbell.libs.common.api.models.Response;
import dev.christopherbell.libs.common.api.exceptions.InvalidRequestException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Represents the controller for dealing with Blog related requests.
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/blog")
public class BlogController {

  private final BlogService blogService;

  /**
   * Takes in an id for a blog post and returns that blog post with the given id.
   *
   * @param id of the blog post
   * @return BlogResponse containing the requested blog post.
   */
  @GetMapping(value = "/v1/posts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<BlogResponse>> getBlogPost(HttpServletRequest request, @PathVariable String id)
      throws InvalidRequestException {
    return new ResponseEntity<>(
        Response.<BlogResponse>builder()
            .payload(blogService.getPostById(id))
            .success(true)
            .build(), HttpStatus.OK);
  }

  /**
   * Returns all existing blog posts.
   *
   * @return a BlogResponse containing all existing blog posts.
   */
  @GetMapping(value = "/v1/posts", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<BlogResponse>> getBlogPosts(HttpServletRequest request) {
    return new ResponseEntity<>(
        Response.<BlogResponse>builder()
            .payload(blogService.getPosts())
            .success(true)
            .build(), HttpStatus.OK);
  }
}
