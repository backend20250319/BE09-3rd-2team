package com.lhw.reviewmanagement.Entity;

import jakarta.annotation.Resource;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Review {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;

    private Long targetId ;

    @Column(nullable = false)
    private String name ;
    @Column(nullable = false)
    private String comment;




    public void createReview(String name, String comment) {
       this.name=name;
       this.comment=comment;
    }

    public void setComment(String comment) {
        this.comment=comment;
    }
}
