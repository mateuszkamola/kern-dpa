package pl.mkamola.kerndpa.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mkamola.kerndpa.models.daos.EntryDao;
import pl.mkamola.kerndpa.models.dtos.EntryDto;
import pl.mkamola.kerndpa.repositories.IEntryRepository;

@Service
public class EntryService {

	@Autowired
	IEntryRepository entryRepository;

	public Iterable<EntryDao> getAllEntries() {
		return entryRepository.findAll();
	}

	public EntryDto daoToDto(EntryDao dao) {
		return new EntryDto(dao.getId(), dao.getTitle(), dao.getContent(), dao.getType());
	}

	public EntryDao save(EntryDao entryDao) {
		return entryRepository.save(entryDao);
	}

	public EntryDao dtoToDao(EntryDto entryDto) {
		return EntryDao.builder()
				.type(entryDto.getType())
				.title(entryDto.getTitle())
				.content(entryDto.getContent())
				.build();
	}
}
