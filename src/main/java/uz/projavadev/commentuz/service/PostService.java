package uz.projavadev.commentuz.service;

import uz.projavadev.commentuz.dto.PostForm;
import uz.projavadev.commentuz.dto.PostListItemDto;

public interface PostService {

    PostListItemDto add(PostForm form);
}
