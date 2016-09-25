package facts.dbo;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "facts")
public class Fact {
	@Id
	private int id;
	private String title;
	private String body; 
	private Date date;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "fact_fk")
	private List<Source> sources;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@JsonIgnore
	public int getId() {
		return id;
	}
	public String getBody() {
		return body;
	}
	public Date getDate() { 
		return date;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setBody(String body) { 
		this.body = body;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Source> getSources() {
		return sources;
	}
	public void setSources(List<Source> sources) {
		this.sources = sources;
	}


}
