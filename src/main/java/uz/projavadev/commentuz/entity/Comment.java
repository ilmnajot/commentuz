package uz.projavadev.commentuz.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Comment extends BaseEntity {

    @Column(columnDefinition = "text")
    private String content;

    @ManyToOne
    private Post post;



}
