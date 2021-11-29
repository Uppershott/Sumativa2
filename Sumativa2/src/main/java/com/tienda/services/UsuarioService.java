package com.tienda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.models.Usuario;
import com.tienda.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public void insertarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public Usuario encontrarUsuarioPorCorreo(String correo) {
		return usuarioRepository.findByEmail(correo);
	}
	
	
}
