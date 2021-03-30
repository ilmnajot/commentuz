package uz.projavadev.commentuz.service.impl;

import org.springframework.stereotype.Service;
import uz.projavadev.commentuz.dto.CommentDto;
import uz.projavadev.commentuz.dto.CommentForm;
import uz.projavadev.commentuz.entity.Comment;
import uz.projavadev.commentuz.entity.Post;
import uz.projavadev.commentuz.repository.CommentRepository;
import uz.projavadev.commentuz.service.CommentService;

import javax.persistence.EntityManager;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;
    private final EntityManager entityManager;

    public CommentServiceImpl(CommentRepository repository, EntityManager entityManager) {
        this.repository = repository;
        this.entityManager = entityManager;
    }

    @Override
    public CommentDto add(CommentForm form) {
        return save(new Comment(), form);
    }

    @Override
    public CommentDto update(Long id, CommentForm form) {
        return save(repository.getOne(id), form);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


    private CommentDto save(Comment comment, CommentForm form) {
        comment.setPost(entityManager.getReference(Post.class, form.getPostId()));
        comment.setContent(form.getContent());
        return CommentDto.toDto(repository.save(comment));
    }
}
