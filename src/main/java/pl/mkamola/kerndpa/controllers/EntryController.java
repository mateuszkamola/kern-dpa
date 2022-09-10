package pl.mkamola.kerndpa.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mkamola.kerndpa.models.daos.EntryDao;
import pl.mkamola.kerndpa.models.dtos.EntryDto;
import pl.mkamola.kerndpa.services.EntryService;

@Controller
public class EntryController {

	@Autowired
	EntryService entryService;

	@GetMapping("/entries")
	public ResponseEntity<List<EntryDto>> getEntries() {
		List<EntryDto> entriesDto = StreamSupport.stream(entryService.getAllEntries().spliterator(), false)
				.map(entryService::daoToDto)
				.collect(Collectors.toList());
		return new ResponseEntity<>(entriesDto, HttpStatus.OK);
	}
}
