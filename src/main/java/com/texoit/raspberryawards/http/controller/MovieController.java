package com.texoit.raspberryawards.http.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.texoit.raspberryawards.dto.IntervalAwards;
import com.texoit.raspberryawards.entity.Movie;
import com.texoit.raspberryawards.entity.WinnerMax;
import com.texoit.raspberryawards.entity.WinnerMin;
import com.texoit.raspberryawards.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public List<Movie> listMovies(){
		return movieService.listMovies();
	}
	
	@GetMapping("/winnersmin")
	public List<WinnerMin> winnersMin(){
		return movieService.listWinnersMin();
	}
	
	@GetMapping("/winnersmax")
	public List<WinnerMax> winnersMax(){
		return movieService.listWinnersMax();
	}
	
	@GetMapping("/intervalawards")
	public IntervalAwards intervalAwards() {
		return movieService.getIntervalAwards();
	}
	
}
