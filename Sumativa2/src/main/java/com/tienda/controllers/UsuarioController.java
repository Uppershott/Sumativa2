package com.tienda.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.models.Producto;
import com.tienda.models.Usuario;
import com.tienda.services.CategoriaService;
import com.tienda.services.ProductoService;
import com.tienda.services.UsuarioService;

@Controller
@Scope("session")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	ProductoService productoService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("/login")
	public String login(@ModelAttribute("usuario") Usuario usuario, HttpSession session, Model model) {
		Usuario usuarioAux = usuarioService.encontrarUsuarioPorCorreo(usuario.getCorreo());
		if(usuarioAux==null) {
			System.out.println("El usuario ingresado no existe");
			return "redirect:/";
		}else if(!usuarioAux.getContrasena().equals(usuario.getContrasena())) {
			System.out.println("La contraseña no coincide con el usuario registrado!");
			return "redirect:/";
		}else {
			
			session.setAttribute("usuario", usuarioAux);
			session.setAttribute("carritoProductos", new ArrayList<Producto>());
			
			model.addAttribute("listaProductos", productoService.encontrarTodosProductos());
			model.addAttribute("listaCategorias", categoriaService.encontrarTodasCategorias());
			
			return "inicio.jsp";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.setAttribute("usuario", new Usuario());
		return "redirect:/";
	}
	
	@RequestMapping("/registrar")
	public String registrar(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "registroUsuario.jsp";
	}
	
	@RequestMapping("/registrarUsuario")
	public String registrarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		Usuario usuarioAux = usuarioService.encontrarUsuarioPorCorreo(usuario.getCorreo());
		if(usuarioAux!=null) {
			System.out.println("Ya existe un usuario con ese correo!");
			return "redirect:/registrar";
		}else {
			usuarioService.insertarUsuario(usuario);
			return "login.jsp";
		}
	}
}
