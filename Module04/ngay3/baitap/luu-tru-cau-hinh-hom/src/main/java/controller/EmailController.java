package controller;

import model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {
    List<String> languageList = new ArrayList<>();
    List<Integer> pageSizeList = new ArrayList<>();

    @GetMapping("")
    public ModelAndView addNew(Model model) {
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        model.addAttribute("languageList", languageList);
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
        model.addAttribute("pageSizeList", pageSizeList);
        return new ModelAndView("email/create", "email", new Email());
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute Email email) {
        return new ModelAndView("email/info", "email", email);
    }
}
