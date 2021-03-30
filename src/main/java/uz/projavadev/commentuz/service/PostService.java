package uz.projavadev.commentuz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import uz.projavadev.commentuz.dto.PostDto;
import uz.projavadev.commentuz.dto.PostForm;
import uz.projavadev.commentuz.dto.PostListItemDto;

import java.io.IOException;

public interface PostService {
    Page<PostListItemDto> findAllByCategory(Long categoryId, Pageable pageable);

    PostDto findOne(Long id);

    PostListItemDto add(MultipartFile image, PostForm form) throws IOException;

    PostListItemDto update(Long id,MultipartFile image, PostForm form) throws IOException;

    void delete(Long id);

}
