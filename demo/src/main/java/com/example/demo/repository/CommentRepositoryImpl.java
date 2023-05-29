//package main.java.com.example.demo.repository;
//
//import com.example.demo.DTO.CommentResponse;
//import com.example.demo.domain.Comment;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//
//import static com.example.demo.DTO.CommentResponse.convertCommentToDto;
//import static com.example.chuchu.comment.entity.QComment.comment;
//
//@RequiredArgsConstructor
//@Repository
//public class CommentRepositoryImpl implements CommentCustomRepository{
//
//    private final JPAQueryFactory queryFactory;
//
//    @Override
//    public List<CommentResponseDTO> findByBoardId(Long id) {
//
//        List<Comment> comments = queryFactory.selectFrom(comment)
//                .leftJoin(comment.parent).fetchJoin()
//                .where(comment.board.id.eq(id))
//                .orderBy(comment.parent.id.asc().nullsFirst(),
//                        comment.createdAt.asc())
//                .fetch();
//
//        List<CommentResponseDTO> commentResponseDTOList = new ArrayList<>();
//        Map<Long, CommentResponseDTO> commentDTOHashMap = new HashMap<>();
//
//        comments.forEach(c -> {
//            CommentResponseDTO commentResponseDTO = convertCommentToDto(c);
//            commentDTOHashMap.put(commentResponseDTO.getId(), commentResponseDTO);
//            if (c.getParent() != null) commentDTOHashMap.get(c.getParent().getId()).getChildren().add(commentResponseDTO);
//            else commentResponseDTOList.add(commentResponseDTO);
//        });
//        return commentResponseDTOList;
//    }
//
//    @Override
//    public Optional<Comment> findCommentByIdWithParent(Long id) {
//
//        Comment selectedComment = queryFactory.select(comment)
//                .from(comment)
//                .leftJoin(comment.parent).fetchJoin()
//                .where(comment.id.eq(id))
//                .fetchOne();
//
//        return Optional.ofNullable(selectedComment);
//    }
//}
