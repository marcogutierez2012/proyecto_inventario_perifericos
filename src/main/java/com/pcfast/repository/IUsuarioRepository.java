package com.pcfast.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcfast.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByIdUsuario(int idUsuario);
	
	Usuario findByCorreoAndPassword(String correo, String password);
	
	Usuario findByCorreo(String correo);
	
	Usuario findByTelefono(String telefono);
	
	List<Usuario> findByNomUsuarioContainingOrApeUsuarioContaining(String nom, String ape);
}
