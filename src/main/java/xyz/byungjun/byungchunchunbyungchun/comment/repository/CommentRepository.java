package xyz.byungjun.byungchunchunbyungchun.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.byungjun.byungchunchunbyungchun.comment.entity.CommentEntity;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findCommentEntitiesByMealId(Long mealId);
}
