package uz.projavadev.commentuz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
    public ResponseEntity add(@RequestParam MultipartFile image, @RequestBody PostForm form) throws IOException {
        return ResponseEntity.ok(service.add(image, form));
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestParam MultipartFile image, @RequestBody PostForm form) throws IOException {
        return ResponseEntity.ok(service.update(id, image, form));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Post deleted");
    }
}
