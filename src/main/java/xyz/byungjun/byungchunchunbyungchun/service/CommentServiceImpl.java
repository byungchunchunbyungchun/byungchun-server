package xyz.byungjun.byungchunchunbyungchun.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.byungjun.byungchunchunbyungchun.dto.CommentDto;
import xyz.byungjun.byungchunchunbyungchun.entity.CommentEntity;
import xyz.byungjun.byungchunchunbyungchun.repository.CommentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public void like(Long id) {
        CommentEntity commentEntity = commentRepository.findById(id).get();
        commentEntity.like();
        commentRepository.save(commentEntity);
    }

    @Override
    public void createComment(CommentDto comment) {
        commentRepository.save(dtoToEntity(comment));
    }

    @Override
    public List<CommentDto> getComments(Long id) {
        return commentRepository.findCommentEntitiesByMealId(id).stream().map(this::entityToDto).toList();
    }

    @Override
    public void updateComment(CommentDto commentDto) {
        CommentEntity commentEntity = commentRepository.findById(commentDto.id()).get();
        commentEntity.fixData(commentDto.comment());
        commentRepository.save(commentEntity);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
