package com.openapi.taxonomiaservice.especies.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.openapi.taxonomiaservice.especies.domain.Familia;
import com.openapi.taxonomiaservice.especies.repository.FamiliaRepository;
import com.openapi.taxonomiaservice.especies.service.EspecieService;
import com.openapi.taxonomiaservice.especies.service.FamiliaService;

@RestController
@RequestMapping(path="api/estados", produces="application/json")
@CrossOrigin(origins="*")

public class EstadoController {
	
	@Autowired
	private FamiliaRepository familiaRepository;
	@Autowired
	private FamiliaService familiaService;
	
	@GetMapping
	public List<Familia> obtenerFamilias() {
		return familiaRepository.findAll();
	}
	
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Familia crearFamilia(@RequestBody Familia familia) {
		return familiaRepository.save(familia);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Familia> obtenerFamiliaPorId(@PathVariable("id") String id) {
		Optional<Familia> familia = familiaRepository.findById(id);
		if (familia.isPresent()) {
			return new ResponseEntity<>(familia.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(path="{id}", consumes="application/json")
	public ResponseEntity<Familia> actualizarFamilia(
			@PathVariable("id") String id, @RequestBody Familia familia) {
		Familia familiaActualizado = familiaService.actualizarFamilia(id, familia);
		if (familiaActualizado != null) {
			return new ResponseEntity<>(familiaActualizado, HttpStatus.OK) ;
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarFamilia(@PathVariable("id") String id) {
		familiaRepository.deleteById(id);
	}

}