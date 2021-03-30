package uz.projavadev.commentuz.service;

import uz.projavadev.commentuz.dto.PostVoteDto;

public interface PostVoteService {

    PostVoteDto upVote(Long postId, String username);

    PostVoteDto downVote(Long postId, String username);

    PostVoteDto revertVote(Long postId, String username);
}
