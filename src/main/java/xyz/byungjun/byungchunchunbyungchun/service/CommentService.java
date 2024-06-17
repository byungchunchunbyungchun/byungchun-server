package xyz.byungjun.byungchunchunbyungchun.service;

import xyz.byungjun.byungchunchunbyungchun.dto.CommentDto;
import xyz.byungjun.byungchunchunbyungchun.entity.CommentEntity;

import java.util.List;

public interface CommentService {


    void createComment(CommentDto comment);
    List<CommentDto> getComments(Long id);
    void updateComment(CommentDto commentDto);
    void deleteComment(Long id);

    default CommentDto entityToDto(CommentEntity commentEntity) {
        return CommentDto.builder()
                .id(commentEntity.getId())
                .comment(commentEntity.getComment())
                .author(commentEntity.getAuthor())
                .count(commentEntity.getCount())
                .mealId(commentEntity.getMealId())
                .build();
    }

    default CommentEntity dtoToEntity(CommentDto commentDto) {
        return CommentEntity.builder()
                .comment(commentDto.comment())
                .author(commentDto.author())
                .count(commentDto.count())
                .mealId(commentDto.mealId())
                .build();
    }

}
