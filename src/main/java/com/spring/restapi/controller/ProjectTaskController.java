package com.spring.restapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restapi.model.ProjectTask;
import com.spring.restapi.service.ProjectTaskService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ProjectTaskController {

	@Autowired
	private ProjectTaskService projectTaskService;

	@PostMapping("")
	public ResponseEntity<?> addPTToBoard(@Valid @RequestBody ProjectTask projectTask) {
		ProjectTask newPT = projectTaskService.saveOrUpdateProjectTask(projectTask);

		return new ResponseEntity<ProjectTask>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<ProjectTask> getAllPTs() {
		return projectTaskService.findAll();
	}

	@GetMapping("/{pt_id}")
	public ResponseEntity<?> getById(@PathVariable Long pt_id) {
		ProjectTask projectTask = projectTaskService.findById(pt_id);
		return new ResponseEntity<ProjectTask>(projectTask, HttpStatus.OK);
	}

	@DeleteMapping("/{pt_id}")
	public ResponseEntity<?> deleteProjectTask(@PathVariable Long pt_id) {
		return new ResponseEntity<String>("Project task deleted ", HttpStatus.OK);

	}

}
