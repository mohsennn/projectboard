package com.spring.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.spring.restapi.model.ProjectTask;
import com.spring.restapi.repository.ProjectTaskRepository;

@Service
public class ProjectTaskService  {

	@Autowired
	private ProjectTaskRepository  projectTaskRepository;

	 public ProjectTask saveOrUpdateProjectTask(ProjectTask projectTask){

	        if(projectTask.getStatus()==null || projectTask.getStatus()==""){
	            projectTask.setStatus("TO_DO");
	        }
	        return projectTaskRepository.save(projectTask);
	    }
	
}
