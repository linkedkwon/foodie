package kr.foodie.domain.member.controller;

import kr.foodie.domain.member.model.Member;
import kr.foodie.domain.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;

@Controller
@RequestMapping(path = "/auth")
public class AuthController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/join")
    public String register(Model model){
        model.addAttribute("member", new Member());
        return "signup";
    }

    @ResponseBody
    @GetMapping(value = "/validate/{email}")
    public String validate(@PathVariable String email){ return memberService.validate(email); }

    //insert user and rendering view
    @PostMapping(value = "/register")
    public String register(Member member){ return memberService.save(member); }

}
