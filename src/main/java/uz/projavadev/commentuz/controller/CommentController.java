package uz.projavadev.commentuz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.projavadev.commentuz.dto.CommentForm;
import uz.projavadev.commentuz.service.CommentService;

@RestController
@RequestMapping("api/v1/comment")
public class CommentController {

    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody CommentForm form) {
        return ResponseEntity.ok(service.add(form));
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody CommentForm form) {
        return ResponseEntity.ok(service.update(id, form));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok("comment deleted");
    }
}
