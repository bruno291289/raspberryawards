package com.texoit.raspberryawards.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Movie implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(name = "year")
	Integer year;
	
	@Column(name = "title")
	String title;
	
	@Column(name = "studios")
	String studios;
	
	@Column(name = "producers")
	String producers;
	
	@Column(name = "winner")
	String winner;
	
	public Boolean hasManyProducers() {
		return this.producers.contains(", ") || this.producers.contains(" and ");
	}
	
	public String[] getProducersList() {
		return this.getProducers().replaceAll(", ", ";").replaceAll(" and ", ";").split(";");
	}
	
	public Movie copyAndPaste() {
		return Movie.builder().year(this.year).title(this.title).studios(this.studios).producers(this.producers).winner(this.winner).build();
	}
	
	public static Movie loadFromCsvString(String line) {
		String[] columns = line.split(";");
		int length = columns.length;
		Movie movie = new Movie();
		
		if(length >= 1)
			movie.year = Integer.parseInt(columns[0]);
		if(length >= 2)
			movie.title = columns[1];
		if(length >= 3)
			movie.studios = columns[2];
		if(length >= 4)
			movie.producers = columns[3];
		if(length >= 5)
			movie.winner = columns[4];
		
		return movie;
	}
	
	public static List<Movie> loadManyFromCsvString(String line){
		List<Movie> movies = new ArrayList<Movie>();
		Movie movie = loadFromCsvString(line);
		
		if (movie.hasManyProducers()) {
			for (String producer : movie.getProducersList()) {
				Movie m = movie.copyAndPaste();
				m.setProducers(producer);
				movies.add(m);
			}
		} else {
			movies.add(movie);
		}
		
		return movies;
	}
	
}
