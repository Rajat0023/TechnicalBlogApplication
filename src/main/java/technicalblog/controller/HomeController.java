package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technicalblog.PostService;
import technicalblog.model.Post;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    public HomeController() {
        System.out.println("*** HomeController ***");
    }

    @RequestMapping("/")
public String getAllposts(Model model)
    {
        ArrayList<Post> posts= postService.getAllPosts();
        model.addAttribute("posts",posts);
        return "index";

    }
}
