package com.tienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tienda.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	
	@Query(value="SELECT * FROM usuarios WHERE correo=?1", nativeQuery=true)
	Usuario findByEmail(String correo);
}
