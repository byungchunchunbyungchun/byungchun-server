package xyz.byungjun.byungchunchunbyungchun.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xyz.byungjun.byungchunchunbyungchun.dto.CommentDto;
import xyz.byungjun.byungchunchunbyungchun.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
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
    public List<CommentDto> getComments(
            @PathVariable Long id
    ) {
        return commentService.getComments(id);
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
