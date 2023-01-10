package xyz.zen.zfc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import xyz.zen.zfc.model.StudySet;
import xyz.zen.zfc.service.StudySetService;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController extends BaseController {

    private final StudySetService studySetService;

    public HomeController(StudySetService studySetService) {
        this.studySetService = studySetService;
    }

    @GetMapping("/home")
    public String home(final Model model, Principal principal) {
        List<StudySet> sets = studySetService.getByUserID(getUserId(principal));
        model.addAttribute("studySets", sets);
        return "home";
    }

}
