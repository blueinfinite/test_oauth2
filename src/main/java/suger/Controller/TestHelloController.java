package suger.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestHelloController {

    @RequestMapping(value = "/greeting")
    public ModelAndView test(ModelAndView mv) {
        mv.setViewName("/greeting");
        mv.addObject("title","欢迎使用Thymeleaf!");
        return mv;
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(ModelAndView mv) {
//        mv.setViewName("/greeting");
//        mv.addObject("title","欢迎使用Thymeleaf!");
        return mv;
    }
}
