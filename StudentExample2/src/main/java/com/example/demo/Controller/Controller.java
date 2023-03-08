package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.*;
import com.example.demo.Service.service;

@RestController
@CrossOrigin
public class Controller {
	@Autowired
	service stdser;
	
	@PostMapping("/addDetails") 
	public entity addinfo(@RequestBody entity st)
	{
		return stdser.saveDetails(st);
	}
	@GetMapping("/showDetails")
	public List<entity> fetchDetails()
	{
		return stdser.getDetails();
	}
	@PutMapping("/updateDetails")
		public entity updateInfo(@RequestBody entity st)
		{
			return stdser.updateDetails(st);
		}
	@DeleteMapping("/deleteDetails/{sid}")
	 String deleteInfo(@PathVariable("sid") int sid) {
		stdser.deleteDetails(sid);
		return "Deleted the data";
	}
	@GetMapping("showDetails/{sname}")
	public List<entity> getWithSort(@PathVariable String sname){
		return stdser.getSorted(sname);
	}
	@GetMapping("showDetails/{offset}/{pageSize}")
	public List<entity> productWithPagination(@PathVariable int offset,@PathVariable int pageSize)
	{
		return stdser.getWithPagination(offset,pageSize);
	}


}