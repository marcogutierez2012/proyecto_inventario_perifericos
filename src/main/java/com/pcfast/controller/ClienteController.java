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

import com.pcfast.model.Cliente;
import com.pcfast.model.TipoCliente;
import com.pcfast.repository.IClienteRepository;
import com.pcfast.repository.ITipoClienteRepository;

@Controller
public class ClienteController {

	@Autowired
	private ITipoClienteRepository repotcli;
	
	@Autowired 
	private IClienteRepository repocli;
	
	@GetMapping("/listarCliente")
	public String listadoCliente(Model model, @RequestParam(name = "search", required = false) String search) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("lstTipoClientes", repotcli.findAll());
		model.addAttribute("lstClientes", repocli.findAll());
		List<Cliente> lstClientes = null;
		
	    if (search != null && !search.isEmpty()) {
	    	lstClientes = repocli.findByNomClienteContainingOrDocClienteContaining(search, search);
	    } else {
	    	lstClientes = repocli.findAll();
	    }

	    model.addAttribute("lstClientes", lstClientes);
		
		return "listadoCliente";
	}
	
	@GetMapping("/corregirCliente")
	public String corregirUsuario(@ModelAttribute("cliente") Cliente cliente,
		    				 @ModelAttribute("lstTiposCliente") List<TipoCliente> lstTiposCliente,
		    				 @ModelAttribute("errorField") String errorField,
		    				 Model model) {
	
	    model.addAttribute("cliente", cliente);
	    model.addAttribute("lstTiposCliente", lstTiposCliente);
	    model.addAttribute("errorField", errorField);
		return "crudCliente";
	}
	
	@GetMapping("/cargarCliente")
	public String cargarCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("lstTipoClientes", repotcli.findAll());
		return "crudCliente";
	}
	
	@PostMapping("/grabarCliente")
	public String grabarCliente(@ModelAttribute Cliente cliente, RedirectAttributes attribute) {
		Cliente clidoc = repocli.findByDocCliente(cliente.getDocCliente());
		if(clidoc == null) {
			repocli.save(cliente);
			attribute.addFlashAttribute("successful", "Cliente Registrado Exitosamente!!!");
			return "redirect:/listarCliente";
		}else {
			attribute.addFlashAttribute("mensaje", "El Cliente con el Documento: "+cliente.getDocCliente()+" ya existe");
			attribute.addFlashAttribute("cliente", cliente);
			attribute.addFlashAttribute("lstTiposCliente", repotcli.findAll());
			attribute.addFlashAttribute("errorField", "docCliente");
		}
		
		return "redirect:/corregirCliente";
	}
	
	@PostMapping("/actualizarCliente")
	public String actualizarCliente(@ModelAttribute Cliente cliente, RedirectAttributes attribute) {
		repocli.save(cliente);
		attribute.addFlashAttribute("successful", "Cliente Actualizado Correctamente!!!");
		return "redirect:/listarCliente";
	}
	
	@PostMapping("/eliminarCliente")
	public String eliminarCliente(@ModelAttribute Cliente cliente, Model model, RedirectAttributes attribute) {
		Cliente usu = repocli.findByIdCliente(cliente.getIdCliente());
		repocli.delete(usu);
		attribute.addFlashAttribute("mensaje", "Cliente Eliminado Correctamente");
		return "redirect:/listarCliente";
	}
}
