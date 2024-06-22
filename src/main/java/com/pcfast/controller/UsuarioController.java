package com.pcfast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pcfast.model.Rol;
import com.pcfast.model.Usuario;
import com.pcfast.repository.IRolRepository;
import com.pcfast.repository.IUsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	private IRolRepository reporol;
	
	@Autowired 
	private IUsuarioRepository repousu;
	
	@GetMapping("/MenuPrincipal")
	public String MenuPrincipal() {
		return "MenuPrincipal";
	}
	
	@GetMapping("/")
	public String formularioLogin(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "login";
	}
	
	@PostMapping("/validar")
	public String validarLogin(@ModelAttribute Usuario usuario, RedirectAttributes attribute) {
		Usuario validarUsuario = repousu.findByCorreoAndPassword(usuario.getCorreo(), usuario.getPassword());
		if(validarUsuario != null) {
			attribute.addFlashAttribute("mensaje", "Bienvenido "+validarUsuario.getNomUsuario()+" "+validarUsuario.getApeUsuario());
			return "redirect:/MenuPrincipal";
		}else {
			attribute.addFlashAttribute("mensaje", "Error iniciando sesión.");
			return "redirect:/";
		}
	}
	
	@GetMapping("/listarUsuario")
	public String listadoUsuario(@RequestParam(name = "search", required = false) String search, Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("lstRoles", reporol.findAll());
		model.addAttribute("lstUsuarios", repousu.findAll());
		List<Usuario> lstUsuarios = null;

	    if (search != null && !search.isEmpty()) {
	        lstUsuarios = repousu.findByNomUsuarioContainingOrApeUsuarioContaining(search, search);
	    } else {
	        lstUsuarios = repousu.findAll();
	    }

	    model.addAttribute("lstUsuarios", lstUsuarios);
		
		return "listadoUsuario";
	}
	
	@GetMapping("/cargarUsuario")
	public String cargarUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("lstRoles", reporol.findAll());
		return "crudUsuario";
	}
	
	@GetMapping("/corregirUsuario")
	public String corregirUsuario(@ModelAttribute("usuario") Usuario usuario,
		    				 @ModelAttribute("lstRoles") List<Rol> lstRoles,
		    				 @ModelAttribute("errorField") String errorField,
		    				 Model model) {
	
	    model.addAttribute("usuario", usuario);
	    model.addAttribute("lstRoles", lstRoles);
	    model.addAttribute("errorField", errorField);
		return "crudUsuario";
	}
	
	@PostMapping("/grabarUsuario")
	public String grabarUsu(@ModelAttribute Usuario usuario, RedirectAttributes attribute) {
		Usuario usucorreo = repousu.findByCorreo(usuario.getCorreo());
		if(usucorreo==null) {
			Usuario usutel = repousu.findByTelefono(usuario.getTelefono());
			if(usutel==null) {
					repousu.save(usuario);
					attribute.addFlashAttribute("successful", "Usuario Registrado Exitosamente!!!");
					return "redirect:/listarUsuario";
				}else{
					attribute.addFlashAttribute("mensaje", "El Usuario con el Teléfono: "+usuario.getTelefono()+" ya existe");
					attribute.addFlashAttribute("usuario", usuario);
					attribute.addFlashAttribute("lstRoles", reporol.findAll());
					attribute.addFlashAttribute("errorField", "telefono");
					}
				}else {
					attribute.addFlashAttribute("mensaje", "El Usuario con el Correo: "+usuario.getCorreo()+" ya existe");
		            attribute.addFlashAttribute("usuario", usuario);
		            attribute.addFlashAttribute("lstRoles", reporol.findAll());
		            attribute.addFlashAttribute("errorField", "correo");
				}
		
		return "redirect:/corregirUsuario";
	}
	
	@PostMapping("/actualizarUsuario")
	public String actualizarUsuario(@ModelAttribute Usuario usuario, RedirectAttributes attribute) {
		repousu.save(usuario);
		attribute.addFlashAttribute("successful", "Usuario Actualizado Exitosamente!!!");
		return "redirect:/listarUsuario";
	}
	
	@PostMapping("/eliminarUsuario")
	public String eliminarUsuario(@ModelAttribute Usuario usuario, Model model, RedirectAttributes attribute) {
		Usuario usu = repousu.findByIdUsuario(usuario.getIdUsuario());
		repousu.delete(usu);
		attribute.addFlashAttribute("mensaje", "Usuario Eliminado Correctamente");
		return "redirect:/listarUsuario";
	}	
}
