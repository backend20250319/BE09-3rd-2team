package com.lhw.reviewmanagement.Entity;


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
    private Long reviewId;

    @JoinColumn(name="scheduleId")
    private Long scheduleId ;

    @JoinColumn(name="userId")
    private Long userId ;

    @Column(nullable = false)
    private String name ;
    @Column(nullable = false)
    private String comment;




    public void setComment(String comment) {
        this.comment=comment;
    }
}
