package pl.sda.bootcamp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bootcamp.model.Course;

@Controller
@RequestMapping(value = "/kurs")
public class CourseController {


    @GetMapping("/lista")
    public String list(@RequestParam(name = "idKursu", required = false) String id,
                       Model model) {
        model.addAttribute("id", id);
        return "course/list";
    }

    @GetMapping("/dodaj")
    public String add(@ModelAttribute Course course, Model model) {
        String[] cities = new String[]{"Warszawa", "Szczecin", "Gdańsk"};
        model.addAttribute("startDate", course.getStartDate());
        model.addAttribute("endDate", course.getEndDate());
        model.addAttribute("price", course.getPrice());
        String[] mode = new String[]{"Dzienne", "Stacjonarne", "Wieczorowe"};
        model.addAttribute("modes", mode);
        model.addAttribute("cities", cities);
        String[] trainers = new String[]{"Jan Janowski", "Marek Marecki"};
        model.addAttribute("trainers", trainers);
        model.addAttribute("course", Course.builder().build());
        return "course/add";
    }

    @PostMapping("/dodaj")
    public String create(@ModelAttribute Course course, Model model) {
        String[] cities = new String[]{"Warszawa", "Szczecin", "Gdańsk"};
        model.addAttribute("cities", cities);
        model.addAttribute("startDate", course.getStartDate());
        model.addAttribute("endDate", course.getEndDate());
        model.addAttribute("price", course.getPrice());
        String[] modes = new String[]{"Dzienne", "Stacjonarne", "Wieczorowe"};
        model.addAttribute("modes", modes);
        String[] trainers = new String[]{"Jan Janowski", "Marek Marecki"};
        model.addAttribute("trainers", trainers);
        model.addAttribute("course", Course.builder().build());
        model.addAttribute("createdCourse", course);
        return "course/add";
    }
}
