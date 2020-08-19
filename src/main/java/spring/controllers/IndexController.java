package spring.controllers;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.services.RecipeService;

/**
 * Created by Piotr
 * Date: 2020-06-15
 * Time: 15:05
 */
@Controller
@Data
@Slf4j
public class IndexController {
    private final RecipeService recipeService;

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){
        log.debug("RequestMapping was invoked");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
