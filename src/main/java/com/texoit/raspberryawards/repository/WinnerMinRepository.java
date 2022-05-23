package com.texoit.raspberryawards.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.texoit.raspberryawards.entity.WinnerMin;

public interface WinnerMinRepository  extends JpaRepository<WinnerMin, String> {

}
