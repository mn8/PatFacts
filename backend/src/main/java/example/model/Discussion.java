package example.model;

import java.time.OffsetDateTime;

/**
 * Created by jdifebo on 5/2/2016.
 */
public class Discussion extends AbstractAuditingModel {
    Long id;
    String title;
    String body;
    
    public Discussion() {}

    public Discussion(Long id, String title, String body, OffsetDateTime createdOn, OffsetDateTime updatedOn) {
    	super(createdOn, updatedOn);
		this.id = id;
		this.title = title;
		this.body = body;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
