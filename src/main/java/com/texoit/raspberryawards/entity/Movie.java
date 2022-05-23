package com.texoit.raspberryawards.entity;

import java.io.Serializable;

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
	
	public Movie loadFromCsvString(String line) {
		String[] columns = line.split(";");
		int length = columns.length;
		
		if(length >= 1)
			this.year = Integer.parseInt(columns[0]);
		if(length >= 2)
			this.title = columns[1];
		if(length >= 3)
			this.studios = columns[2];
		if(length >= 4)
			this.producers = columns[3];
		if(length >= 5)
			this.winner = columns[4];
		
		return this;
	}
	
}
