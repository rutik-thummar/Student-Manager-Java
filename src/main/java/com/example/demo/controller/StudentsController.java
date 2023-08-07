package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentsDTO;
import com.example.demo.repository.StudentsRepository;
import com.example.demo.service.StudentsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping(path="students")
public class StudentsController {

	@Autowired(required = false)
	StudentsService studentService;

	@Autowired(required = false)
	StudentsRepository studentRepository;

	@GetMapping(value = "", produces = "application/json")
	public List<StudentsDTO> getList() {
		return studentService.getList();
	}

	@PostMapping(value = "", produces = "application/json", consumes = "application/json")
	public StudentsDTO add(@RequestBody StudentsDTO studentAdd) {
		return studentService.add(studentAdd);
	}

	@PutMapping(value = "", produces = "application/json", consumes = "application/json")
	public StudentsDTO update(@RequestBody StudentsDTO studentUpdate) {
		return studentService.update(studentUpdate);
	}

	@DeleteMapping(value = "{id}", produces = "application/json")
	public void delete(@PathVariable("id") int id) {
		studentService.deleteById(id);
	}

	@GetMapping(value = "{id}", produces = "application/json")
	public StudentsDTO getById(@PathVariable("id") long id) {
		return studentService.getById(id);
	}
}
