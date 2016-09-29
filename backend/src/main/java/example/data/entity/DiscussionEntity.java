//package example.data.entity;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EntityListeners;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.Version;
//
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import example.model.Discussion;
// 
//@Entity
//@EntityListeners(AuditingEntityListener.class)
//@Table(name = "discussions")
//public class DiscussionEntity extends AuditingEntity{
//// 
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
//// 
////    @Column(name = "body", length = 500)
////    private String body;
////
////    @Column(name = "title", nullable = false, length = 100)
////    private String title;
////
////    @Version
////    private long version;
////
////	public DiscussionEntity(String title, String body) {
////		this.body = body;
////		this.title = title;
////	}
////     
////	public DiscussionEntity() {}
////
////	public Long getId() {
////		return id;
////	}
////
////	public void setId(Long id) {
////		this.id = id;
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
////	public String getTitle() {
////		return title;
////	}
////
////	public void setTitle(String title) {
////		this.title = title;
////	}
////
////	public long getVersion() {
////		return version;
////	}
////
////	public void setVersion(long version) {
////		this.version = version;
////	}
////
////	public Discussion toModel(){
////		return new Discussion(id, title, body, this.getCreatedOn(), this.getUpdatedOn());
////	}
//    
//}