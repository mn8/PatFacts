package example.model;

import java.time.OffsetDateTime;

public abstract class AbstractAuditingModel {
	
    private OffsetDateTime createdOn;
    private OffsetDateTime updatedOn;
    
    public AbstractAuditingModel() {}

	public AbstractAuditingModel(OffsetDateTime createdOn, OffsetDateTime updatedOn) {
		super();
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public OffsetDateTime getCreatedOn() {
		return createdOn;
	}

//	public void setCreatedOn(OffsetDateTime createdOn) {
//		this.createdOn = createdOn;
//	}

	public OffsetDateTime getUpdatedOn() {
		return updatedOn;
	}

//	public void setUpdatedOn(OffsetDateTime updatedOn) {
//		this.updatedOn = updatedOn;
//	}
}
