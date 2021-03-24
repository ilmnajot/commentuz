package uz.projavadev.commentuz.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Post extends BaseEntity {

    private String name;

    private String image;

    @OneToMany
    private Set<Comment> comments;

    private Long userId;

    @ManyToMany
    private List<Tag> tags;

    @ManyToOne
    private SubCategory subCategoryId;
}
