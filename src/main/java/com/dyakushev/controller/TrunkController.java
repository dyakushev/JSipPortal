package com.dyakushev.controller;

import com.dyakushev.model.Trunk;
import com.dyakushev.service.TrunkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/trunk")
@PreAuthorize("isAuthenticated()")
public class TrunkController {
    @Autowired
    private TrunkService trunkService;

    @GetMapping
    public String trunkList(Model model) {
        model.addAttribute("trunks", trunkService.findAll());
        return "configuration/trunkList";
    }

    @PostMapping
    public String trunkFilter(
            @RequestParam String filter,
            Model model) {
        Iterable<Trunk> trunks;
        if (filter == null || filter.isEmpty())
            trunks = trunkService.findAll();
        else
            trunks = trunkService.findByIpaddress(filter);
        model.addAttribute("trunks", trunks);
        model.addAttribute("filter", filter);
        return "configuration/trunkList";
    }

    @GetMapping("/new")
    public String newTrunkForm(
            @ModelAttribute("trunk") Trunk trunk) {
        return "configuration/trunkNew";
    }


    @PostMapping("/new")
    public String saveNewTrunk(
            @Valid @ModelAttribute("trunk") Trunk trunk,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "configuration/trunkNew";
        } else {
            trunkService.save(new Trunk(trunk.getIpaddress(), trunk.getPort(), trunk.getDescription(), trunk.getActive()));
            Iterable<Trunk> trunks = trunkService.findAll();
            model.addAttribute("trunks", trunks);
            return "configuration/trunkList";
        }
    }


    @GetMapping("/remove/{id}")
    public String trunkRemove(@PathVariable Long id, Model model) {
        Trunk trunk = trunkService.findById(id);
        if (trunk != null)
            trunkService.removeTrunk(trunk);
        Iterable<Trunk> trunks = trunkService.findAll();
        model.addAttribute("trunks", trunks);
        return "redirect:/trunk";
    }

    @GetMapping("/edit/{id}")
    public String trunkEditForm(
            @PathVariable Long id,
            Model model) {
        Trunk trunk = trunkService.findById(id);
        model.addAttribute("trunk", trunk);
        return "configuration/trunkEdit";
    }

    @PostMapping("/edit/{id}")
    public String saveEditAccount(
            @PathVariable Long id,
            @Valid @ModelAttribute("trunk") Trunk trunk,

            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {

            return "configuration/trunkEdit";
        } else {
            trunkService.saveEditTrunk(id, trunk);
            return "redirect:/trunk";
        }
    }
}

