package com.texoit.raspberryawards.service;

import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.texoit.raspberryawards.RaspberryawardsApplication;
import com.texoit.raspberryawards.dto.IntervalAwards;
import com.texoit.raspberryawards.entity.Movie;
import com.texoit.raspberryawards.entity.WinnerMax;
import com.texoit.raspberryawards.entity.WinnerMin;
import com.texoit.raspberryawards.repository.MovieRepository;
import com.texoit.raspberryawards.repository.WinnerMaxRepository;
import com.texoit.raspberryawards.repository.WinnerMinRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private WinnerMinRepository winnerMinRepository;
	
	@Autowired
	private WinnerMaxRepository winnerMaxRepository;
	
	@Value("${application.file_data_name}")
	private String fileName;
	
	@EventListener(ApplicationReadyEvent.class)
	public void loadMovies() {
		System.out.println("----------Carregando planilha inicial---------------");
		System.out.println(fileName);
		
		System.out.println(new RaspberryawardsApplication().getClass().getClassLoader().getResource(fileName).toString());
        try (CSVReader reader = new CSVReader(new FileReader(new File(new RaspberryawardsApplication().getClass().getClassLoader().getResource(fileName).toURI()), StandardCharsets.UTF_8))) {
        	List<String[]> r = reader.readAll();
            //r.forEach(x -> System.out.println(Arrays.toString(x)));
            
            List<Movie> movies = new ArrayList<Movie>();
            
            for (int i = 1; i < r.size(); i++) {
            	String[] strings = r.get(i);
            	//System.out.println(Arrays.toString(strings));
            	String linha = Arrays.toString(strings);
            	linha = linha.substring(1, linha.length()-1);
            	//System.out.println(linha);
				movies.addAll(Movie.loadManyFromCsvString(linha));
			}
            
            //for (Movie movie : movies) {
			//	System.out.println(movie.toString());
			//}
            
            movieRepository.saveAll(movies);
            
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("----------Fim do carregamento---------------");
	}
	
	public List<Movie> listMovies(){
		return movieRepository.findAll();
	}
	
	public List<WinnerMin> listWinnersMin(){
		return winnerMinRepository.findAll();
	}
	
	public List<WinnerMax> listWinnersMax(){
		return winnerMaxRepository.findAll();
	}
	
	public IntervalAwards getIntervalAwards() {
		IntervalAwards awards = new IntervalAwards();
		awards.setMax(listWinnersMax());
		awards.setMin(listWinnersMin());
		return awards;
	}
	
}
