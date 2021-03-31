package uz.projavadev.commentuz.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.projavadev.commentuz.dto.PostDto;
import uz.projavadev.commentuz.dto.PostForm;
import uz.projavadev.commentuz.dto.PostListItemDto;
import uz.projavadev.commentuz.entity.Comment;
import uz.projavadev.commentuz.entity.Post;
import uz.projavadev.commentuz.entity.SubCategory;
import uz.projavadev.commentuz.entity.Tag;
import uz.projavadev.commentuz.repository.CommentRepository;
import uz.projavadev.commentuz.repository.PostRepository;
import uz.projavadev.commentuz.repository.TagRepository;
import uz.projavadev.commentuz.service.PostService;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final EntityManager entityManager;
    private final TagRepository tagRepository;

    public PostServiceImpl(PostRepository postRepository, CommentRepository commentRepository, EntityManager entityManager, TagRepository tagRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.entityManager = entityManager;
        this.tagRepository = tagRepository;
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
    public PostListItemDto add(PostForm form) throws IOException {
        return save(new Post(), form);
    }

    @Override
    public PostListItemDto update(Long id, PostForm form) throws IOException {
        return save(postRepository.getOne(id), form);
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    private PostListItemDto save(Post post, PostForm form) throws IOException {
        String filename = form.getImage().getOriginalFilename();
        post.setImage(filename);
        post.setSubCategoryId(entityManager.getReference(SubCategory.class, form.getSubcategoryIid()));
        Set<Tag> tags =new HashSet<>();
        for (Long id : form.getTagId()) {
            tags.add(tagRepository.getOne(id));
        }
        post.setTags(tags);
        post.setName(form.getName());
        postRepository.save(post);
        String uploadDir = "post-photos/" + post.getId();
        saveFile(uploadDir, filename, form.getImage());
        return new PostDto.Builder(post).build();
    }

    private static void saveFile(String uploadDir, String fileName,
                                 MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }
}
