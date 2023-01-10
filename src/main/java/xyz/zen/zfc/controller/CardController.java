package xyz.zen.zfc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.zen.zfc.dto.Message;
import xyz.zen.zfc.model.Card;
import xyz.zen.zfc.service.CardService;

import java.security.Principal;
import java.util.UUID;

@Controller
@RequestMapping("/set/{setId}/card")
public class CardController extends BaseController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public String createCardPage(final Model model, @PathVariable UUID setId) {
        Card card = new Card();
        card.setSetId(setId);
        model.addAttribute("card", card);
        return "create-card";
    }

    @PostMapping
    public String createCardSubmit(Model model, @ModelAttribute Card card, Principal principal) {
        card.setUserId(getUserId(principal));
        Card saved = cardService.create(card);
        model.addAttribute("message", new Message("Card", saved.toString()));
        return "redirect:/study-set/" + card.getSetId();
    }


}
