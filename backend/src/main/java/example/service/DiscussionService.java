//package example.service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import example.data.entity.DiscussionCommentEntity;
//import example.data.entity.DiscussionEntity;
//import example.data.repository.DiscussionCommentRepository;
//import example.data.repository.DiscussionRepository;
//import example.exception.CommentNotFoundException;
//import example.exception.DiscussionNotFoundException;
//import example.model.Discussion;
//import example.model.DiscussionComment;
//
///**
// * Created by jdifebo on 5/2/2016.
// */
//@Service
//public class DiscussionService {
//
//	@Autowired
//	DiscussionRepository discussionRepository;
//
//	@Autowired
//	DiscussionCommentRepository commentRepository;
//
//    public List<Discussion> getAllDiscussions() {
//        return discussionRepository.findAll().map(entity -> entity.toModel()).collect(Collectors.toList());
//    }
//
//    public Discussion createDiscussion(Discussion discussion) {
//    	DiscussionEntity toSave = new DiscussionEntity(discussion.getTitle(), discussion.getBody());
//        return discussionRepository.save(toSave).toModel();
//    }
//
//    public Discussion getDiscussion(Long discussionId) {
//        return discussionRepository.findOne(discussionId).map(entity -> entity.toModel())
//        		.orElseThrow(() -> new DiscussionNotFoundException());
//    }
//
//    public Discussion editDiscussion(Long discussionId, Discussion discussion) {
//    	DiscussionEntity toEdit = discussionRepository.findOne(discussionId)
//        		.orElseThrow(() -> new DiscussionNotFoundException());
//    	toEdit.setTitle(discussion.getTitle());
//    	toEdit.setBody(discussion.getBody());
//    	DiscussionEntity edited = discussionRepository.save(toEdit);
//    	return edited.toModel();
//    }
//
//    public void deleteDiscussion(long discussionId) {
//    	DiscussionEntity toDelete = discussionRepository.findOne(discussionId)
//        		.orElseThrow(() -> new DiscussionNotFoundException());
//    	discussionRepository.delete(toDelete);
//    }
//
//    public List<DiscussionComment> getDiscussionComments(Long discussionId) {
//        return commentRepository.findByDiscussionId(discussionId).stream().map(entity -> entity.toModel()).collect(Collectors.toList());
//    }
//
//    public DiscussionComment createDiscussionComment(Long discussionId, DiscussionComment discussionComment) {
//    	DiscussionCommentEntity toSave = new DiscussionCommentEntity(discussionId, discussionComment.getBody());
//    	return commentRepository.save(toSave).toModel();
//    }
//
//    public DiscussionComment getDiscussionComment(Long discussionId, Long commentId) {
//        return commentRepository.findOne(commentId).map(entity -> entity.toModel())
//        		.orElseThrow(() -> new CommentNotFoundException());
//    }
//
//    public DiscussionComment editDiscussionComment(Long discussionId, Long commentId, DiscussionComment discussionComment) {
//        DiscussionCommentEntity toEdit = commentRepository.findOne(commentId)
//        		.orElseThrow(() -> new CommentNotFoundException());
//        toEdit.setBody(discussionComment.getBody());
//        return commentRepository.save(toEdit).toModel();
//    }
//
//    public void deleteDiscussionComment(Long discussionId, Long commentId) {
//    	DiscussionCommentEntity toEdit = commentRepository.findOne(commentId)
//        		.orElseThrow(() -> new CommentNotFoundException());
//        commentRepository.delete(toEdit);
//    }
//}
