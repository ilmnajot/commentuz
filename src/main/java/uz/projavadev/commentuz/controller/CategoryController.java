package uz.projavadev.commentuz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.projavadev.commentuz.dto.CategoryDto;
import uz.projavadev.commentuz.service.CategoryService;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody CategoryDto dto) {
        return ResponseEntity.ok(service.add(dto));
    }
}
