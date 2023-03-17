package springmvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import jakarta.servlet.http.HttpSession;
import springmvc.entities.Job;
import springmvc.entities.JobRepository;

@Controller
public class JobsController {
	@Autowired
	JobRepository jobRepo;

	@GetMapping("/jobs")
	public String getAllJobs(Model model, @SessionAttribute("user") String user, HttpSession session) {
		List<Job> jobs = jobRepo.findAll();
		model.addAttribute("jobs", jobs);
		return "jobslist";
	}
	
	@GetMapping("/job/add")
	public String newJobForm() {
		return "newjob";
	}

	@PostMapping("/job/add")
	public String processNewJob(Model model, Job job) {
		try {
			jobRepo.save(job);
			model.addAttribute("message", "Successfully added new job!!");
		} catch (Exception ex) {
			model.addAttribute("message", "Sorry! Error -> " + ex.getMessage());
		}
		return "newjob";

	}
	
	@GetMapping("/job/edit")
	public String editJobForm() {
		return "editjob";
	}

	@PostMapping("/job/edit")
	public String processEditJob(Model model, String id, String title) {
		try {
			var job = jobRepo.findById(id);
			if(job.isEmpty())
				model.addAttribute("message", "Sorry! Job Id Not Found!");
			else {
				var jobEntity = job.get();
				jobEntity.setTitle(title);
				jobRepo.save(jobEntity);
			    model.addAttribute("message", "Successfully updated job!!");
			}
		} catch (Exception ex) {
			model.addAttribute("message", "Sorry! Error -> " + ex.getMessage());
		}
		return "editjob";

	}

	@GetMapping("/job/update/{id}")
	public String updateJobForm(@PathVariable("id") String id, Model model) {
		var entity = jobRepo.findById(id);
		model.addAttribute("job", entity.get());
		return "updatejob";
	}
	
	@PostMapping("/job/update/{id}")
	public String updateJobForm(@PathVariable("id") String id, Job job, Model model) {
		var entity = jobRepo.findById(id);
		var jobEntity = entity.get();
		jobEntity.setTitle(job.getTitle());
		jobEntity.setMinsal(job.getMinsal());
		jobRepo.save(jobEntity);
		return "redirect:/jobs";  
	}
	
	
	@GetMapping("/job/delete/{id}")
	public String deleteJob(@PathVariable("id") String id, Model model) {
		jobRepo.deleteById(id);
		model.addAttribute("job", id);
		return "jobDeleted";
		
	}
}
