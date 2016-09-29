package example.model;

import java.time.OffsetDateTime;

/**
 * A DiscussionComment refers to a discussion and has a block of text.  The commentNumber refers to the comment number
 * in a specific discussion; comments in different discussions can have the same number so it is not a unique
 * identifier by itself.  Hopefully I don't regret that decision!
 *
 * Created by jdifebo on 5/8/2016.
 */
public class DiscussionComment extends AbstractAuditingModel {
	Long id;
    Long discussionId;
    String body;
    
    OffsetDateTime createdOn;
    
    OffsetDateTime updatedOn;
    
    public DiscussionComment() {}

	public DiscussionComment(Long id, Long discussionId, String body, OffsetDateTime createdOn, OffsetDateTime updatedOn) {
		super(createdOn, updatedOn);
		this.id = id;
		this.discussionId = discussionId;
		this.body = body;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(Long discussionId) {
        this.discussionId = discussionId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
