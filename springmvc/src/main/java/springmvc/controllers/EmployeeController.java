package springmvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.entities.Employee;
import springmvc.entities.EmployeeRepo;
import springmvc.entities.Job;
import springmvc.entities.JobRepository;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeRepo empRepo;
	@Autowired
	private JobRepository jobRepo;

	@GetMapping("/employees")
	public String getEmployeesByJob(@RequestParam("jobid") String jobId, ModelMap model) {
		List<Employee> employees = empRepo.getEmployeesByJob(jobId);
		model.addAttribute("employees", employees);
		model.addAttribute("job", jobId);
		return "employees";
	}

	 
	@GetMapping("/empbyjob")
	public String employeesByJob(ModelMap model) {
		Iterable<Job> jobs = jobRepo.findAll();
		Job job = new Job();
		model.addAttribute("job",job);
		model.addAttribute("jobs", jobs);
		return "empByJob";
	}
	
	@PostMapping(value = "/empbyjob")
	public String employeesByJob(Job job, ModelMap model) {
		Iterable<Job> jobs = jobRepo.findAll();
		model.addAttribute("job",job);
		model.addAttribute("jobs", jobs );
		// Get all employees by given department id
		model.addAttribute("employees",empRepo.getEmployeesByJob(job.getId()));
		return "empByJob";
	}
}
