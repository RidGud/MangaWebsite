package com.example.MangaWebsite.Controller;

import com.example.MangaWebsite.Model.Truyen;
import com.example.MangaWebsite.Service.TruyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class ContentController {
    @Autowired
    private TruyenService truyenService;

    @GetMapping("/Content")
    public String Content(){
        return "Content";
    }

    //edit
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model){
        Optional<Truyen> detailTruyen = Optional.ofNullable(truyenService.getTruyenById(id));
        List<Truyen> truyens = truyenService.getAllTruyens();
        model.addAttribute("truyens", truyens);
        if (detailTruyen.isPresent()) {
            Truyen truyen = detailTruyen.get();
            model.addAttribute("truyen", truyen);
            return "/truyenDetail";
        }
        else
            return "redirect:/error";
    }
}
