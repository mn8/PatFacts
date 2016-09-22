package facts.dbo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "facts")
public class Facts {
	@Id
	private int id;
	private String fact; 
	private Date date;
	
	public int getId() {
		return id;
	}
	public String getFact() {
		return fact;
	}
	public Date getDate() {
		return date;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFact(String fact) { 
		this.fact = fact;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
