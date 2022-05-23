package com.texoit.raspberryawards.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.texoit.raspberryawards.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
