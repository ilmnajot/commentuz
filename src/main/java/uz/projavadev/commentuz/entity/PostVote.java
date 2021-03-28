package uz.projavadev.commentuz.entity;

import lombok.Data;
import uz.projavadev.commentuz.dto.VoteType;

import javax.persistence.*;

@Entity
@Data
public class PostVote extends BaseEntity {

    @ManyToOne
    private Post post;

    @Enumerated(EnumType.STRING)
    private VoteType type;
}
