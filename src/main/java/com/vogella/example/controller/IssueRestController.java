package com.vogella.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vogella.example.IssueReport;
import com.vogella.example.repositories.IssueRepository;

@RestController
public class IssueRestController {
	
	IssueRepository issueRepository;
	
	public IssueRestController(IssueRepository issueRepository) {
		this.issueRepository = issueRepository;
	}
	
    @GetMapping(value="/api/issues")
    public List<IssueReport> getIssues() {
        return this.issueRepository.findAllButPrivate();
    }

    @GetMapping(value="/api/issues/{id}")
    public IssueReport getIssue(@PathVariable(value="id") long id) {
    	return this.issueRepository.findById(id);
    }

}
