/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.webcontrollers;

import java.util.concurrent.atomic.AtomicLong;
import lv.rtme.fxui.models.CodesOrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@Controller
public class SearchController {
    @Autowired private CodesOrderModel codesModel;
    
    
    
     @RequestMapping("/search")
    public String search(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("codes", codesModel);
        return "search";
    }
}
    

