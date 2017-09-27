package jp.co.ws.training.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.ws.training.form.M0001Form;
import jp.co.ws.training.service.UserService;

@Controller
@RequestMapping("M0001")
public class M0001Controller {

    @Autowired
    UserService userService;

    @ModelAttribute
    M0001Form setUpForm() {
        return new M0001Form();
    }

}
