package org.zerock.mapper.ex03;

import java.util.List;

import org.zerock.domain.ex02.ReplyDto;

public interface Ex04Mapper {

	int insertReply(ReplyDto reply);

	List<ReplyDto> selectReplyByBoardId(int boardId);

	int deleteReplyById(int id);

	int updateReply(ReplyDto reply);

	// 게시글 지우기 전 댓글 지우기
	void deleteReplyByBoard(int boardId);

}
