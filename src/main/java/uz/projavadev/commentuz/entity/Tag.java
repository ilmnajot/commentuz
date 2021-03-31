package uz.projavadev.commentuz.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Tag extends BaseEntity {

    private String name;

}
