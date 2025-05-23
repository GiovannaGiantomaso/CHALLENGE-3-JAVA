package com.example.Odontoprev.controller;

import com.example.Odontoprev.model.Usuario;
import com.example.Odontoprev.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("erroMensagem", "Usuário ou senha incorretos!");
        }
        if (logout != null) {
            model.addAttribute("logoutMensagem", "Você saiu com sucesso!");
        }
        return "login";
    }

    @GetMapping("/register")
    public String mostrarCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "register";
    }

    @PostMapping("/register")
    public String registrarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.salvarUsuario(usuario);
        return "redirect:/login?registrado";
    }
}
