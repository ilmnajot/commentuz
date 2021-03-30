package uz.projavadev.commentuz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.projavadev.commentuz.service.PostVoteService;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/vote")
public class PostVoteController {

    private final PostVoteService service;

    public PostVoteController(PostVoteService service) {
        this.service = service;
    }

    @PutMapping("{postId}/up")
    public ResponseEntity upVote(@PathVariable Long postId, Principal principal){
        return ResponseEntity.ok(service.upVote(postId,principal.getName()));
    }

    @PutMapping("{postId}/down")
    public ResponseEntity downVote(@PathVariable Long postId,Principal principal){
        return ResponseEntity.ok(service.downVote(postId,principal.getName()));
    }

    @PutMapping("{postId}/revert")
    public ResponseEntity revertVote(@PathVariable Long postId, Principal principal){
        return ResponseEntity.ok(service.revertVote(postId,principal.getName()));
    }
}
