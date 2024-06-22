package com.pcfast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pcfast.model.Comprobante;
import com.pcfast.repository.IComprobanteRepository;
import com.pcfast.repository.ITipoComprobanteRepository;

@Controller
public class ComprobanteController {

	@Autowired
	private ITipoComprobanteRepository repotcom;
	
	@Autowired 
	private IComprobanteRepository repocom;
	
	@GetMapping("/listarComprobante")
	public String listadoComprobante(Model model) {
		model.addAttribute("comprobante", new Comprobante());
		model.addAttribute("lstTipoComprobantes", repotcom.findAll());
		model.addAttribute("lstComprobantes", repocom.findAll());
		return "listadoComprobante";
	}
	
	@GetMapping("/cargarComprobante")
	public String cargarComprobante(Model model) {
		model.addAttribute("comprobante", new Comprobante());
		model.addAttribute("lstTipoComprobantes", repotcom.findAll());
		return "cargarComprobante";
	}
	
	@PostMapping("/generarComprobante")
	public String generarComprobante(@ModelAttribute Comprobante comprobante) {
		repocom.save(comprobante);
		return "redirect:/listarComprobante";
	}	
}
