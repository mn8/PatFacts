package example.model;
public class SourceModel {
	private String source;
	private String name;

	public SourceModel(String source, String name){
		this.source = source;
		this.name = name;
	}
	public String getSource() {
		return source;
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
