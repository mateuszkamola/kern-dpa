package pl.mkamola.kerndpa.models.dtos;

public class NoteDTO {
	int id;
	String content;

	public NoteDTO() {
	}

	public NoteDTO(int id, String content) {
		this.id = id;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
