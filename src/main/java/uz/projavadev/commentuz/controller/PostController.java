package uz.projavadev.commentuz.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.projavadev.commentuz.dto.PostForm;
import uz.projavadev.commentuz.service.PostService;
import uz.projavadev.commentuz.service.impl.UserServiceImpl;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/post")
public class PostController {

    private final PostService postService;
    private final UserServiceImpl userService;

    public PostController(PostService postService, UserServiceImpl userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity add(PostForm form) throws IOException {
        return ResponseEntity.ok(postService.add(form));
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Long id, PostForm form) throws IOException {
        return ResponseEntity.ok(postService.update(id, form));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok("Post deleted");
    }

    @GetMapping("{id}")
    public ResponseEntity getAll(@PathVariable Long id, Pageable pageable) {
        return ResponseEntity.ok(postService.findAllByPostPages(id, pageable));
    }

    @GetMapping("createdBy")
    public ResponseEntity getCreatedBy(Pageable pageable) {
        return ResponseEntity.ok(postService.findAllByCreatedBy((userService.currentUser().get().getUsername()), pageable));
    }

}
