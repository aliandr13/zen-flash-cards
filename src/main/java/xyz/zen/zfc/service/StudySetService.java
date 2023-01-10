package xyz.zen.zfc.service;

import org.springframework.stereotype.Service;
import xyz.zen.zfc.entity.StudySetEntity;
import xyz.zen.zfc.mapper.StudySetMapper;
import xyz.zen.zfc.model.StudySet;
import xyz.zen.zfc.repository.StudySetRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudySetService {

    private final StudySetRepository studySetRepository;
    private final StudySetMapper studySetMapper;

    public StudySetService(StudySetRepository studySetRepository, StudySetMapper studySetMapper) {
        this.studySetRepository = studySetRepository;
        this.studySetMapper = studySetMapper;
    }

    public List<StudySet> getAll() {
        return studySetRepository.findAll().stream().map(studySetMapper::map).collect(Collectors.toList());
    }

    public List<StudySet> getByUserID(UUID userID) {
        return studySetRepository.findByUserId(userID).stream().map(studySetMapper::map).collect(Collectors.toList());
    }

    public StudySet create(StudySet studySet) {
        StudySetEntity save = studySetRepository.save(studySetMapper.map(studySet));
        return studySetMapper.map(save);
    }

}
