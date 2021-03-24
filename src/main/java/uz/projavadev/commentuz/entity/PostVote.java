package uz.projavadev.commentuz.entity;

import lombok.Data;
import uz.projavadev.commentuz.dto.VoteType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class PostVote extends BaseEntity {

    @OneToMany
    private List<Post> post;

    @Enumerated(EnumType.STRING)
    private VoteType type;
}
