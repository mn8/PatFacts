package facts.dbo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="sources")
public class Source {
	@Id
	private int id;
	private String source;
	private String name;
	public int getId() {
		return id;
	}
	public String getSource() {
		return source;
	}
	@JsonIgnore
	public void setId(int id) {
		this.id = id;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
