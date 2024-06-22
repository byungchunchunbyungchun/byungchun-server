package xyz.byungjun.byungchunchunbyungchun.comment.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Long count;

    @Column(nullable = false)
    private Long mealId;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    @Builder
    public CommentEntity(String comment, String author, Long count, Long mealId) {
        this.comment = comment;
        this.author = author;
        this.count = count;
        this.mealId = mealId;
        this.createDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    public void fixData(String comment){
        this.comment = comment;
        this.updateDate = LocalDateTime.now();
    }

    public void like(){
        this.count++;
    }
}
