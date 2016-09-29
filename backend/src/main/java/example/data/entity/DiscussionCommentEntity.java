//package example.data.entity;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import example.model.DiscussionComment;
// 
//@Entity
//@Table(name = "discussion_comments")
//public class DiscussionCommentEntity extends AuditingEntity{
////  
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////	
////	@Column(name = "discussion_id")
////    Long discussionId;
////
////    @Column(name = "body", length = 500)
////    private String body;
////    
////    public DiscussionCommentEntity() {}
////    
////    public DiscussionCommentEntity(Long discussionId, String body) {
////		super();
////		this.discussionId = discussionId;
////		this.body = body;
////	}
////
////	public DiscussionComment toModel(){
////    	return new DiscussionComment(id, discussionId, body, this.getCreatedOn(), this.getUpdatedOn());
////    }
////	
////	public Long getId() {
////		return id;
////	}
////
////	public void setId(Long id) {
////		this.id = id;
////	}
////
////	public Long getDiscussionId() {
////		return discussionId;
////	}
////
////	public void setDiscussionId(Long discussionId) {
////		this.discussionId = discussionId;
////	}
////
////	public String getBody() {
////		return body;
////	}
////
////	public void setBody(String body) {
////		this.body = body;
////	}
////    
//    
//}
//
