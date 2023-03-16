package springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import springmvc.entities.Job;
import springmvc.entities.JobRepository;

@Controller
public class JobsController {
	@Autowired
	JobRepository jobRepo;

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
}
