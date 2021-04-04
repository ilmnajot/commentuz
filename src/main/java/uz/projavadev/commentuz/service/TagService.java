package uz.projavadev.commentuz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.projavadev.commentuz.dto.TagDto;

public interface TagService {

    Page<TagDto> findAll(Pageable pageable);

    Page<TagDto> search(String searchTerm, Pageable pageable);

    TagDto add(TagDto form);

    TagDto update(Long id, TagDto form);

    void delete(Long id);


}
