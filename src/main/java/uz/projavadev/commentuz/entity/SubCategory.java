package uz.projavadev.commentuz.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class  SubCategory extends BaseEntity {

    private String name;

    @ManyToOne
    private Category category;
}
