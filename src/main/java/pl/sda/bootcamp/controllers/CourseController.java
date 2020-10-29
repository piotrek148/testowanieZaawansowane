package pl.sda.bootcamp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.bootcamp.model.Course;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/kurs")
public class CourseController {


    @GetMapping("/lista")
    public String list(Model model) {
        Course kurs1 = new Course(1L,
                "Javawwa25",
                "Warszawa",
                Date.valueOf("2020-07-05"),
                Date.valueOf("2020-01-01"),
                2300,
                "Dzienne",
                "Jan Jaśkowiak");
        Course kurs2 = new Course(2L,
                "Pajton",
                "Górka",
                Date.valueOf("2018-05-17"),
                Date.valueOf("2020-03-14"),
                7400,
                "Dzienne",
                "Jan Jaśkowiak");
        List<Course> kursy = Arrays.asList(kurs1, kurs2);
        model.addAttribute("kursy", kursy);
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
        String trainer = "Jan Janowski";
        model.addAttribute("trainers", trainer);
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
        String trainer = "Jan Janowski";
        model.addAttribute("trainers", trainer);
        model.addAttribute("course", Course.builder().build());
        model.addAttribute("createdCourse", course);
        return "course/add";
    }
}
