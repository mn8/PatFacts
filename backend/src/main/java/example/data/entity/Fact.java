package example.data.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import example.model.FactModel;

@Entity
@Table(name= "facts")
public class Fact {
	@Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private String body; 
	private LocalDate date;
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinColumn(name = "fact_fk")
	private List<Source> sources;
	public Fact(){
		
	}
	public Fact(String title, String body, LocalDate date){
		this.title = title;
		this.body = body;
		this.date = date;
	}
	
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
	public LocalDate getDate() { 
		return date;
	}
	public void setBody(String body) { 
		this.body = body;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public List<Source> getSources() {
		return sources;
	}
	public void setSources(List<Source> sources) {
		this.sources = sources;
	}
	@Override
	public String toString(){
		return "id:"+id+" Title: "+title+" Body:"+body+" Date: "+date;
	}

	public FactModel toModel(){
		return new FactModel(body, title, date, sources);
		
		
	}

}
