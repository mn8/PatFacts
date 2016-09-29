//package example.data.entity;
//import java.time.OffsetDateTime;
//
//import javax.persistence.Column;
//import javax.persistence.EntityListeners;
//import javax.persistence.MappedSuperclass;
//
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
// 
//@EntityListeners(AuditingEntityListener.class)
//@MappedSuperclass
//public abstract class AuditingEntity {
// 
////    @Column(name = "created_on", nullable = false)
////    @CreatedDate
////    private OffsetDateTime createdOn;
////    
////    @Column(name = "updated_on")
////    @LastModifiedDate
////    private OffsetDateTime updatedOn;
////
////	public OffsetDateTime getCreatedOn() {
////		return createdOn;
////	}
////
////	public OffsetDateTime getUpdatedOn() {
////		return updatedOn;
////	}
//}