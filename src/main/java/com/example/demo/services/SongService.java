package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Songs;

@Service
public interface SongService {

	public  void addSong(Songs song);

	public List<Songs> fetchAllSongs();

	public boolean songNameExists(String name);

	public void updateSong(Songs song);

}
