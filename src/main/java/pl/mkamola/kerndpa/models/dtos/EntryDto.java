package pl.mkamola.kerndpa.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class EntryDto {
	int id;
	String title;
	String content;
	String type;
}
