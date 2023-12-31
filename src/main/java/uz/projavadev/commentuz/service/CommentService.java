package uz.projavadev.commentuz.service;

import uz.projavadev.commentuz.dto.CommentDto;
import uz.projavadev.commentuz.dto.CommentForm;

public interface CommentService {

    CommentDto add(CommentForm form);

    CommentDto update(Long id, CommentForm form);

    void delete(Long id);
}
