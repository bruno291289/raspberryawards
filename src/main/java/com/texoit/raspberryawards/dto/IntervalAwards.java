package com.texoit.raspberryawards.dto;

import java.io.Serializable;
import java.util.List;

import com.texoit.raspberryawards.entity.WinnerMax;
import com.texoit.raspberryawards.entity.WinnerMin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IntervalAwards implements Serializable {

	private static final long serialVersionUID = 1L;
	
	List<WinnerMin> min;
	List<WinnerMax> max;

}
