package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Songs;
import com.example.demo.repositories.SongRepository;

@Service
public class SongServiceImplementation implements SongService{

	
		@Autowired
		SongRepository repo;
		
		@Override
		public void addSong(Songs song) {
		repo.save(song);
		
		
	}

		@Override
		public List<Songs> fetchAllSongs() {
			
			return repo.findAll();
		}

		@Override
		public boolean songNameExists(String name) {
			Songs song=repo.findByName(name) ;
			if(song==null) {
				return false;
				
			}
			else {
				return true;
			}
			

		}

		@Override
		public void updateSong(Songs song) {
			repo.save(song);
			
		}
}
