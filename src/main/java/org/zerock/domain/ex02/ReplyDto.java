package org.zerock.domain.ex02;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReplyDto {
	private int id;
	private int boardId;  // board_id column과 매칭되도록 별칭(as)주기
	private String content;
	private LocalDateTime inserted;
}
