package com.texoit.raspberryawards.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Subselect;
import org.springframework.data.annotation.Immutable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Immutable
@Subselect("select * from winners_min")
public class WinnerMin implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String producer;
	@Column(name = "intervals")
	private Integer interval;
	@Column(name = "previouswin")
	private Integer previousWin;
	@Column(name = "followingwin")
	private Integer followingWin;


}
