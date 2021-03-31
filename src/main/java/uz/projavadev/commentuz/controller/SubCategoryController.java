package uz.projavadev.commentuz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.projavadev.commentuz.dto.SubCategoryDto;
import uz.projavadev.commentuz.service.SubCategoryService;

@RestController
@RequestMapping("api/v1/subCategory")
public class SubCategoryController {

    private final SubCategoryService service;

    public SubCategoryController(SubCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody SubCategoryDto dto) {
        return ResponseEntity.ok(service.add(dto));
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody SubCategoryDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("subCategory deleted");
    }
}
