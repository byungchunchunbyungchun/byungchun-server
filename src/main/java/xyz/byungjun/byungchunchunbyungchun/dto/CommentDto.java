package xyz.byungjun.byungchunchunbyungchun.dto;

import lombok.Builder;

@Builder
public record CommentDto(
        Long id,
        String comment,
        String author,
        Long count,
        Long mealId
) {
}