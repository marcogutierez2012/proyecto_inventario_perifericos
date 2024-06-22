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

import com.pcfast.model.Producto;
import com.pcfast.model.TipoProducto;
import com.pcfast.repository.IProductoRepository;
import com.pcfast.repository.ITipoProductoRepository;

@Controller
public class ProductoController {

	@Autowired
	private ITipoProductoRepository repotpro;
	
	@Autowired 
	private IProductoRepository repopro;
	
	@GetMapping("/listarProducto")
	public String listadoProducto(Model model, @RequestParam(name = "search", required = false) String search) {
		model.addAttribute("producto", new Producto());
		model.addAttribute("lstTipoProductos", repotpro.findAll());
		model.addAttribute("lstProductos", repopro.findAll());
		List<Producto> lstProducto = null;
		
	    if (search != null && !search.isEmpty()) {
	    	lstProducto = repopro.findByDesProductoContainingOrTipoproductoDesTipoProductoContaining(search, search);
	    } else {
	    	lstProducto = repopro.findAll();
	    }

	    model.addAttribute("lstProductos", lstProducto);
		
		return "listadoProducto";
	}
	
	@GetMapping("/cargarProducto")
	public String cargarProducto(Model model) {
		model.addAttribute("producto", new Producto());
		model.addAttribute("lstTipoProductos", repotpro.findAll());
		return "crudProducto";
	}
	
	@GetMapping("/corregirProducto")
	public String corregirUsuario(@ModelAttribute("producto") Producto producto,
		    				 @ModelAttribute("lstTipoProducto") List<TipoProducto> lstTipoProducto,
		    				 @ModelAttribute("errorField") String errorField,
		    				 Model model) {
	
	    model.addAttribute("producto", producto);
	    model.addAttribute("lstTipoProducto", lstTipoProducto);
	    model.addAttribute("errorField", errorField);
		return "crudProducto";
	}
	
	@PostMapping("/grabarProducto")
	public String grabarProducto(@ModelAttribute Producto producto, RedirectAttributes attribute) {
		Producto prodes = repopro.findByDesProducto(producto.getDesProducto());
		if(prodes == null) {
			repopro.save(producto);
			attribute.addFlashAttribute("successful", "Producto Registrado Exitosamente!!!");
			return "redirect:/listarProducto";
		}else {
			attribute.addFlashAttribute("mensaje", "El Producto : "+producto.getDesProducto()+" ya existe");
			attribute.addFlashAttribute("producto", producto);
			attribute.addFlashAttribute("lstTipoProducto", repotpro.findAll());
			attribute.addFlashAttribute("errorField", "desProducto");
		}
		
		return "redirect:/corregirProducto";
	}
	
	@PostMapping("/actualizarProducto")
	public String actualizarProducto(@ModelAttribute Producto producto, RedirectAttributes attribute) {
		repopro.save(producto);
		attribute.addFlashAttribute("successful", "Producto Actualizado Correctamente!!!");
		return "redirect:/listarProducto";
	}
	
	@PostMapping("/eliminarProducto")
	public String eliminarProducto(@ModelAttribute Producto producto, Model model, RedirectAttributes attribute) {
		Producto pro = repopro.findByIdProducto(producto.getIdProducto());
		repopro.delete(pro);
		attribute.addFlashAttribute("mensaje", "Producto Eliminado Correctamente");
		return "redirect:/listarProducto";
	}
}
