package uz.projavadev.commentuz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.projavadev.commentuz.dto.PostDto;
import uz.projavadev.commentuz.dto.PostForm;
import uz.projavadev.commentuz.dto.PostListItemDto;

import java.io.IOException;

public interface PostService {

    Page<PostListItemDto> findAllByPostPages(Long subCategoryId, Pageable pageable);

    Page<PostListItemDto> findAllByCreatedBy(String username, Pageable pageable);

    PostDto findOne(Long id);

    PostListItemDto add(PostForm form) throws IOException;

    PostListItemDto update(Long id, PostForm form) throws IOException;

    void delete(Long id);

}
