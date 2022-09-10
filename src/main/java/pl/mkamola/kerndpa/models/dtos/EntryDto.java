package pl.mkamola.kerndpa.models.dtos;

public class EntryDto {
	int id;
	String title;
	String content;
	String type;

	public EntryDto(int id, String title, String content, String type) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.type = type;
	}

	public EntryDto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
