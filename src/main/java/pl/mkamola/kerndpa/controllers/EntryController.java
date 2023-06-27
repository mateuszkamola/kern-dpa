package pl.mkamola.kerndpa.controllers;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.mkamola.kerndpa.models.daos.EntryDao;
import pl.mkamola.kerndpa.models.dtos.EntryDto;
import pl.mkamola.kerndpa.services.EntryService;

@Controller
public class EntryController {

	@Autowired
	EntryService entryService;

	@GetMapping("/entries")
	@CrossOrigin(origins="http://mkamola.pl:3000")
	public ResponseEntity<List<EntryDto>> getEntries() {
		List<EntryDto> entriesDto = StreamSupport.stream(entryService.getAllEntries().spliterator(), false)
				.map(entryService::daoToDto)
				.toList();
		return new ResponseEntity<>(entriesDto, HttpStatus.OK);
	}

	@PostMapping("/entries")
	@CrossOrigin(origins="http://mkamola.pl:3000")
	public ResponseEntity<EntryDto> storeEntries(@RequestBody EntryDto entryDto) {
		System.out.printf("Got new entry %s, %s, %s\n", entryDto.getTitle(), entryDto.getType(), entryDto.getContent());
		EntryDao entryDao = entryService.dtoToDao(entryDto);
		entryDao.setCreatedAt(Timestamp.from(Instant.now()));
		entryDao = entryService.save(entryDao);
		return new ResponseEntity<>(entryService.daoToDto(entryDao), HttpStatus.OK);
	}
}
