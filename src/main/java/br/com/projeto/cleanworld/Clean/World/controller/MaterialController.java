package br.com.projeto.cleanworld.Clean.World.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.cleanworld.Clean.World.dao.MaterialDAO;
import br.com.projeto.cleanworld.Clean.World.model.Material;

@RestController
@RequestMapping("/materiais")
public class MaterialController {
	
	@Autowired
	private MaterialDAO dao;
	
	@PostMapping
	public void insert(@RequestBody Material mate) {
		dao.save(mate);
	}
	
	@GetMapping
	public List<Material> findAll() {
		return dao.findAll();
	}
	
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Material> findById(@PathVariable Integer id){
		return dao.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());	
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Material> update(@PathVariable("id") Integer id,
										   @RequestBody Material mate){
		return dao.findById(id)
				.map(record -> {
					record.setDsMaterial(mate.getDsMaterial());
					record.setTipoMaterial(mate.getTipoMaterial());
					record.setPontuacao(mate.getPontuacao());
					
					Material updMaterial = dao.save(record);
					return ResponseEntity.ok().body(updMaterial);
				}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		return dao.findById(id)
				.map(record -> {
					dao.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
	
}
