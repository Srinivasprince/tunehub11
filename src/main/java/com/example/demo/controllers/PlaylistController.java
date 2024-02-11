package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Playlist;
import com.example.demo.entities.Songs;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongService;


@Controller
public class PlaylistController {
	@Autowired
	SongService songService;
	@Autowired 
	PlaylistService playlistService;
	@GetMapping("/createPlaylists")
	public String createPlaylist(Model model) {
		List<Songs>songList=songService.fetchAllSongs();
		model.addAttribute("songs",songList);
		return "createPlaylists";
		
	}
	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist) {
		
	
	playlistService.addPlaylist(playlist);
	//updating song table
	List<Songs> songList=playlist.getSong();
	for (Songs s : songList) {
		s.getPlaylists().add(s);
		songService.updateSong(s);
		
	}
	return "adminhome";
	

}
}
