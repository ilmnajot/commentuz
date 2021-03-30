package uz.projavadev.commentuz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.projavadev.commentuz.dto.PostDto;
import uz.projavadev.commentuz.dto.PostForm;
import uz.projavadev.commentuz.dto.PostListItemDto;

public interface PostService {
    Page<PostListItemDto> findAllByCategory(Long categoryId, Pageable pageable);

    PostDto findOne(Long id);

    PostListItemDto add(PostForm form);

    PostListItemDto update(Long id, PostForm form);

    void delete(Long id);

}
