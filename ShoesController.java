package com.example.crud.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.crud.db.ShoeRepository;
import com.example.crud.model.Shoes;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "shoes")
public class ShoesController {
	
	
	private byte[] bytes;

		@Autowired
		private ShoeRepository shoeRepository;
		
		@GetMapping("/get")
		public List<Shoes> getShoes() {
			return shoeRepository.findAll();
		}
		
		@PostMapping("/upload")
		public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
			this.bytes = file.getBytes();
		}

		@PostMapping("/add")
		public void createShoes(@RequestBody Shoes shoe) throws IOException {
			shoe.setPicByte(this.bytes);
			shoeRepository.save(shoe);
			this.bytes = null;
			
		}
		
		@DeleteMapping(path = { "/{id}" })
		public Shoes deleteShoes(@PathVariable("id") long id) {
			Shoes shoe = shoeRepository.getOne(id);
			shoeRepository.deleteById(id);
			return shoe;
		}
		@PutMapping("/update")
		public void updateShoes(@RequestBody Shoes shoe) {
			shoeRepository.save(shoe);
		}
	}

