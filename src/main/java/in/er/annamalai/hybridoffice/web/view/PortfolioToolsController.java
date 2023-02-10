package in.er.annamalai.portfolio.web.view;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.er.annamalai.portfolio.dto.PortfolioDTO;
import in.er.annamalai.portfolio.service.PortfolioService;

@Controller
@RequestMapping("/tools")
public class PortfolioToolsController {

    @GetMapping
    public String tools(Model model) {
        return "tools";
    }

    @GetMapping("/{toolName}")
    public String tool(@PathVariable String toolName, Model model) {
        return "tools/"+toolName;
    }
}
