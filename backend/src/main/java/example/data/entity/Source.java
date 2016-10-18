package example.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import example.model.SourceModel;
@Entity
@Table(name="sources")
public class Source {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String source;
	private String name;
	private int fact_fk;
	
	public Source(){
		
	}
	public Source(String source, String name){
		this.source = source; 
		this.name = name;
	}
/*	public int getId() {
		return id;
	}*/
	public String getSource() {
		return source;
	}
/*	@JsonIgnore
	public void setId(int id) {
		this.id = id;
	}*/
	public void setSource(String source) {
		this.source = source;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getFact_fk() {
		return fact_fk;
	}
	public void setFact_fk(int fact_fk) {
		this.fact_fk = fact_fk;
	}
	public SourceModel toModel(){
		return new SourceModel(this.source, this.name);
	}
	public String toString(){
		return "Source{ id: "+id + "source" + source + " name " + name + " }";
	}
	

}
