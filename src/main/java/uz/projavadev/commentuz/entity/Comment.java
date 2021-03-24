package uz.projavadev.commentuz.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Comment extends BaseEntity {

    private String content;

    private Long userId;
}
