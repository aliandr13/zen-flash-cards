package xyz.zen.zfc.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.zen.zfc.entity.StudySetEntity;
import xyz.zen.zfc.repository.StudySetRepository;

import java.util.List;

@RestController
@RequestMapping("/api/study-set")
public class StudySetApiController {

    private final StudySetRepository studySetRepository;

    public StudySetApiController(StudySetRepository studySetRepository) {
        this.studySetRepository = studySetRepository;
    }

    @GetMapping()
    public List<StudySetEntity> getAll() {
        return studySetRepository.findAll();
    }

}
