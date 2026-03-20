package com.ihletada.fullstackapp.controllers.view

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class MainController {
    @GetMapping("/")
    fun index() = "index"


    @GetMapping("/hello")
    fun hello(@RequestParam name: String?, model: Model): String {
        model.addAttribute("name", name ?: "Guest")
        return "fragments/hello-fragment :: hello-fragment"
    }
}