package com.example.ozancikriklioglu;

import com.example.ozancikriklioglu.FighterJet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/fighterjets")
public class FighterJetViewController {


    private static List<FighterJet> jets = new ArrayList<>();

    @GetMapping("/list")
    public String listFighterJets(Model model) {
        model.addAttribute("jets", jets);
        return "fighterjet-list";
    }

    @GetMapping("/add")
    public String addFighterJetForm(Model model) {
        model.addAttribute("fighterJet", new FighterJet());
        return "fighterjet-form";
    }

    @PostMapping("/add")
    public String addFighterJetSubmit(@ModelAttribute FighterJet fighterJet) {
        fighterJet.setId(jets.size() + 1);
        jets.add(fighterJet);
        return "redirect:/fighterjets/list";
    }
}
