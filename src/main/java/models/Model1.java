package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Model1 {
    private long id;		//TODO:Why "Final?
    private String content;
	public Model1(@JsonProperty("id") long id,
				  @JsonProperty("content") String content) {
		super();
		this.id = id;
		this.content = content;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public boolean isValid() {
		content = this.getContent();
		if (content.length() < 4 || content.length() > 30) {
			return false;
		}
		return true;
		
	}


}
