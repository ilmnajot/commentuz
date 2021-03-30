package uz.projavadev.commentuz.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.projavadev.commentuz.dto.PostDto;
import uz.projavadev.commentuz.dto.PostForm;
import uz.projavadev.commentuz.dto.PostListItemDto;
import uz.projavadev.commentuz.entity.Comment;
import uz.projavadev.commentuz.entity.Post;
import uz.projavadev.commentuz.entity.SubCategory;
import uz.projavadev.commentuz.entity.Tag;
import uz.projavadev.commentuz.repository.CommentRepository;
import uz.projavadev.commentuz.repository.PostRepository;
import uz.projavadev.commentuz.service.PostService;
import uz.projavadev.commentuz.service.TagService;

import javax.persistence.EntityManager;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final EntityManager entityManager;
    private final TagService tagService;

    public PostServiceImpl(PostRepository postRepository, CommentRepository commentRepository, EntityManager entityManager, TagService tagService) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.entityManager = entityManager;
        this.tagService = tagService;
    }


    @Override
    public Page<PostListItemDto> findAllByCategory(Long categoryId, Pageable pageable) {
        return postRepository.findBySubCategoryId(categoryId, pageable)
                .map(post -> new PostDto.Builder(post).build());
    }

    @Override
    public PostDto findOne(Long id) {
        Post post = postRepository.getOne(id);
        postRepository.save(post.incrementViewCount());
        List<Comment> comments = commentRepository.findByPost(post);
        return new PostDto.Builder(post).comments(comments).build();
    }

    @Override
    public PostListItemDto add(PostForm form) {
        return save(new Post(), form);
    }

    @Override
    public PostListItemDto update(Long id, PostForm form) {
        return save(postRepository.getOne(id), form);
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    private PostListItemDto save(Post post, PostForm form) {

        File file = new File("D:\\upload");

//        file

        post.setImage(form.getImage().getName());
        post.setSubCategoryId(entityManager.getReference(SubCategory.class, form.getSubcategoryIid()));
        post.setName(form.getName());
        if (form.getTags() != null) {
            post.setTags(form.getTags().stream().map(tagDto -> {
                if (tagDto.getId() == null) {
                    tagDto = tagService.add(tagDto);
                }
                return entityManager.getReference(Tag.class, tagDto.getId());
            }).collect(Collectors.toSet()));
        }
        postRepository.save(post);
        return new PostDto.Builder(post).build();
    }
}