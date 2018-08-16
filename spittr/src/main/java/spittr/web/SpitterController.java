package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spittr.entity.Spitter;
import spittr.entity.Spittle;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/7/15
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(Spitter spitter) {
        System.out.println("form: " + spitter);
        return "redirect:/spitter/" + spitter.getUserName();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        Spitter spitter = new Spitter("孙", "宝龙", "voodoo", "123456");
        model.addAttribute(spitter);
        return "profile";
    }
}
