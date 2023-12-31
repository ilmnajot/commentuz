package uz.projavadev.commentuz.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Post extends BaseEntity {

    private String name;

    private String image;

    private String content;

    @Column(nullable = false)
    private Long viewCount = 0L;

    @Column(nullable = false)
    private Long voteCount = 0L;

    @ManyToMany
    private Set<Tag> tags;

    @ManyToOne
    private SubCategory subCategory;

    @Transient
    public Post incrementViewCount() {
        this.viewCount++;
        return this;
    }

}
