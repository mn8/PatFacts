package example.service;

import org.springframework.beans.factory.annotation.Autowired;

import example.data.entity.Source;
import example.data.repository.SourcesRepository;
import example.model.SourceModel;

public class SourceService {
	@Autowired
	SourcesRepository sourceRepository;
	
	public SourceModel createSource(SourceModel source){
		Source entityToSave = new Source(source.getName(), source.getSource());
		return sourceRepository.save(entityToSave).toModel();
	}
}
