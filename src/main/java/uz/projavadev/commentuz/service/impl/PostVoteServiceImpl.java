package uz.projavadev.commentuz.service.impl;

import org.springframework.stereotype.Service;
import uz.projavadev.commentuz.dto.PostVoteDto;
import uz.projavadev.commentuz.dto.VoteType;
import uz.projavadev.commentuz.entity.Post;
import uz.projavadev.commentuz.entity.PostVote;
import uz.projavadev.commentuz.repository.PostRepository;
import uz.projavadev.commentuz.repository.PostVoteRepository;
import uz.projavadev.commentuz.service.PostVoteService;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
public class PostVoteServiceImpl implements PostVoteService {

    private final PostVoteRepository postVoteRepository;
    private final PostRepository postRepository;
    private final EntityManager entityManager;

    public PostVoteServiceImpl(PostVoteRepository postVoteRepository, PostRepository postRepository, EntityManager entityManager) {
        this.postVoteRepository = postVoteRepository;
        this.postRepository = postRepository;
        this.entityManager = entityManager;
    }

    @Override
    public PostVoteDto upVote(Long postId, String username) {
        return null;
    }

    @Override
    public PostVoteDto downVote(Long postId, String username) {
        return vote(postId, VoteType.UP, username);
    }

    @Override
    public PostVoteDto revertVote(Long postId, String username) {
        return vote(postId, VoteType.DOWN, username);
    }

    private PostVoteDto vote(Long postId, VoteType type, String username) {
        Optional<PostVote> optionalPostVote = postVoteRepository.findByPostId(postId, username);
        if (optionalPostVote.isPresent()) {
            PostVote vote = new PostVote();
            vote.setPost(entityManager.getReference(Post.class, postId));
            vote.setType(type);
            PostVoteDto dto = PostVoteDto.toDto(postVoteRepository.save(vote));
            reCalculatePostVote(dto.getPostId());
            return dto;
        }
        return null;
    }

    private void reCalculatePostVote(Long postId) {
        Post post = new Post();
        Long voteCount = postVoteRepository.countByPost(post, VoteType.UP)
                - postVoteRepository.countByPost(post, VoteType.DOWN);
        post.setVoteCount(voteCount);
        postRepository.save(post);
    }
}
