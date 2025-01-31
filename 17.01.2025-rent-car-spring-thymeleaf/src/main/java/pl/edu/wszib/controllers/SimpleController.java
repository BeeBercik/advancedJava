package pl.edu.wszib.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.model.Car;

import java.util.List;
import java.util.Random;

@Controller
public class SimpleController {

    @RequestMapping(path = "/method1", method = RequestMethod.GET)
    public String method1() {
        System.out.println("method1 works - sout");

        return "index";
    }

    @RequestMapping(path = "/method2", method = RequestMethod.GET)
    public String method2(@RequestParam(name = "name") String name,
                          @RequestParam(name = "surname") String surname) {
        System.out.println(name);
        System.out.println(surname);

        return "index";
    }

    @RequestMapping(path = "/method3/{name}/{surname}", method = RequestMethod.GET)
    public String method3(@PathVariable(name = "name") String name,
                          @PathVariable(name = "surname") String surname) {
        System.out.println(name);
        System.out.println(surname);

        return "index";
    }

    @RequestMapping(path = "/form", method = RequestMethod.GET)
    public String form() {
        return "form";
    }

    @RequestMapping(path = "/form", method = RequestMethod.POST)
    public String form(@RequestParam(name = "name") String name,
                        @RequestParam(name = "surname") String surname) {
        System.out.println(name);
        System.out.println(surname);

        return "index";
    }

    @RequestMapping(path = "/method4", method = RequestMethod.GET)
    public String method4(Model model) {
        List<String> names = List.of("Robert", "Kamil", "Weronika");
        String randomName = names.get(new Random().nextInt(names.size()));

        model.addAttribute("name", randomName);
        model.addAttribute("allNames", names);

        return "names";
    }

    @RequestMapping(path = "/carForm", method = RequestMethod.GET)
    public String carForm(Model model) {
        model.addAttribute("car", new Car());

        return "carForm";
    }

    @RequestMapping(path = "/carForm", method = RequestMethod.POST)
    public String carForm(@ModelAttribute Car car) {
        System.out.println(car);

        return "index";
    }
}