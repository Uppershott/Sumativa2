package com.tienda.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.models.Producto;
import com.tienda.models.Usuario;
import com.tienda.services.CategoriaService;
import com.tienda.services.ProductoService;

@Controller
@Scope("session")
public class HomeController {

	@Autowired
	ProductoService productoService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("")
	public String inicio(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login.jsp";
	}
	
	@RequestMapping("/inicio")
	public String inicio(Model model, HttpSession session) {
		//session.setAttribute("carritoProductos", new ArrayList<Producto>());
		
		model.addAttribute("listaProductos", productoService.encontrarTodosProductos());
		model.addAttribute("listaCategorias", categoriaService.encontrarTodasCategorias());
		return "inicio.jsp";
	}
}
