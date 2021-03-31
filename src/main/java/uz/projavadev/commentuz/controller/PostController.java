package uz.projavadev.commentuz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.projavadev.commentuz.dto.PostForm;
import uz.projavadev.commentuz.service.PostService;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/post")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity add(PostForm form) throws IOException {
        return ResponseEntity.ok(service.add(form));
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Long id, PostForm form) throws IOException {
        return ResponseEntity.ok(service.update(id, form));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Post deleted");
    }
}
