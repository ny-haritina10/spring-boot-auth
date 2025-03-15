package mg.itu.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        return "auth/login";
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        return "back-office/dashboard";
    }
}