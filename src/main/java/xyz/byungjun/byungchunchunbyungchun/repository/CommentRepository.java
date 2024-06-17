package xyz.byungjun.byungchunchunbyungchun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.byungjun.byungchunchunbyungchun.entity.CommentEntity;
import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findCommentEntitiesByMealId(Long mealId);
}
