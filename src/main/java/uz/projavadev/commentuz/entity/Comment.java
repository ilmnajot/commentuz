package uz.projavadev.commentuz.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class Comment extends BaseEntity {

    @Column(columnDefinition = "text")
    private String content;

    private Long userId;
}
