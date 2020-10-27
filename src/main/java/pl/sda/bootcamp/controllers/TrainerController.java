package pl.sda.bootcamp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bootcamp.model.Trainer;


@Controller
@RequestMapping(value = "/trener")
public class TrainerController {


    @GetMapping("/dodaj")
    public String add(@ModelAttribute Trainer trainer, Model model) {
        model.addAttribute("firstName", trainer.getFirstName());
        model.addAttribute("lastName", trainer.getLastName());
        model.addAttribute("hourlyRate", trainer.getHourlyRate());
        model.addAttribute("trainer", Trainer.builder().build());
        return "trainer/add";
    }

    @PostMapping("/dodaj")
    public String create(@ModelAttribute Trainer trainer, Model model) {
        model.addAttribute("firstName", trainer.getFirstName());
        model.addAttribute("lastName", trainer.getLastName());
        model.addAttribute("hourlyRate", trainer.getHourlyRate());
        model.addAttribute("trainer", Trainer.builder().build());
        model.addAttribute("createdTrainer", trainer);
        return "trainer/add";
    }
}
