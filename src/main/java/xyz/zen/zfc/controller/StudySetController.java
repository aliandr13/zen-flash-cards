package xyz.zen.zfc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.zen.zfc.model.Card;
import xyz.zen.zfc.model.StudySet;
import xyz.zen.zfc.service.CardService;
import xyz.zen.zfc.service.StudySetService;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/study-set")
public class StudySetController extends BaseController {

    private final StudySetService studySetService;
    private final CardService cardService;

    public StudySetController(StudySetService studySetService, CardService cardService) {
        this.studySetService = studySetService;
        this.cardService = cardService;
    }

    @GetMapping
    public String createSetPage(final Model model) {
        model.addAttribute("set", new StudySet());
        return "create-study-set";
    }

    @PostMapping
    public String createSetSubmit(final Model model, @ModelAttribute final StudySet studySet, final Principal principal) {
        studySet.setUserId(getUserId(principal));
        StudySet saved = studySetService.create(studySet);
//        model.addAttribute("message", new Message("Study set", saved.toString()));
//        return "message";
        return "redirect:home";
    }

    @GetMapping("/{setId}")
    public String getSetPage(Model model, @PathVariable UUID setId) {
        List<Card> cards = cardService.getBySetId(setId);
        model.addAttribute("cards", cards);
        model.addAttribute("setId", setId.toString());
        return "study-set";
    }

}
