package example.model;

import java.time.LocalDate;
import java.util.List;

import example.data.entity.Source;

public class FactModel {

	private String title;
	private String body; 
	private LocalDate date;
	private List<Source> sources;
	
	public FactModel(String title, String body, LocalDate date, List<Source> sources){
		this.title = title;
		this.body = body;
		this.date = date;
		this.sources = sources;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
}
