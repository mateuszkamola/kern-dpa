package pl.mkamola.kerndpa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mkamola.kerndpa.models.dtos.NoteDTO;

@Controller
public class NoteController {

	@GetMapping("/notes")
	public ResponseEntity<NoteDTO> getNotes() {
		return new ResponseEntity<>(new NoteDTO(123, "Hello world!"), HttpStatus.OK);
	}
}
