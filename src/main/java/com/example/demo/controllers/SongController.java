package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entities.Songs;
import com.example.demo.services.SongService;


@Controller
public class SongController {
	@Autowired
	SongService service;
	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Songs song) {
		boolean songStatus=service.songNameExists(song.getName());
		if(songStatus==false) {
			service.addSong(song);
		System.out.println("song added successfully");
		}
		else {
			System.out.println("alredy exists");
		}
		
		
		return "adminHome";
	}
	@GetMapping("/viewSongs")
	public String viewSongs(Model model) {
		List<Songs>songsList=service.fetchAllSongs();
		model.addAttribute("songs",songsList);
		
		return "displaySongs";
	}
	@GetMapping("/playSongs")
	public String playSongs(Model model) {
		boolean premiumUser=true;
		if(premiumUser==true) {
			
		
		List<Songs>songsList=service.fetchAllSongs();
		model.addAttribute("songs",songsList);
		
		return "displaySongs";
	
	}
		else {
			
		
		return "makePayment";
		}
	

}
}
