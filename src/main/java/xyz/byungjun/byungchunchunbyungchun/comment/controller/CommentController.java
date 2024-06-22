package xyz.byungjun.byungchunchunbyungchun.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xyz.byungjun.byungchunchunbyungchun.comment.dto.CommentDto;
import xyz.byungjun.byungchunchunbyungchun.core.dto.BaseDTO;
import xyz.byungjun.byungchunchunbyungchun.comment.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3002")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/like/{id}")
    public void like(
            @PathVariable Long id
    ) {
        commentService.like(id);
    }

    @PostMapping
    public void createComment(
            @RequestBody CommentDto commentDto
    ) {
        commentService.createComment(commentDto);
    }

    @GetMapping("/{id}")
    public BaseDTO<List<CommentDto>> getComments(
            @PathVariable Long id
    ) {
        return new BaseDTO<>(200, commentService.getComments(id));
    }

    @PutMapping
    public void updateComment(
            @RequestBody CommentDto commentDto
    ) {
        commentService.updateComment(commentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(
            @PathVariable Long id
    ) {
        commentService.deleteComment(id);
    }



}
