package com.example.intermediate.controller.response;

import java.time.LocalDateTime;
import java.util.List;

import com.example.intermediate.domain.Recomment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDto {
  private Long id;
  private String author;
  private String content;
  private int likenum;
  private List<RecommentResponseDto> recommentResponseDtos;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
}
