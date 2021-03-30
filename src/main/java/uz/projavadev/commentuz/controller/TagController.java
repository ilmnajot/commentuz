package uz.projavadev.commentuz.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.projavadev.commentuz.dto.TagDto;
import uz.projavadev.commentuz.service.TagService;


@RestController
@RequestMapping("api/v1/tag")
public class TagController {

    private final TagService service;

    public TagController(TagService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody TagDto form) {
        return ResponseEntity.ok(service.add(form));
    }

    @GetMapping
    public ResponseEntity findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("search")
    public ResponseEntity search(@RequestParam String searchTerm, Pageable pageable) {
        return ResponseEntity.ok(service.search(searchTerm, pageable));
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody TagDto form) {
        return ResponseEntity.ok(service.update(id, form));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("tag deleted");
    }
}
