package com.example.inversion_control;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MobilesConfig {
	@Bean
	public Color getColorObject() {
		return new Color();
	}
	@Bean
	public Mobiles getOnePlusObject(Color color) {
		return new OnePlus(color);
	}
	@Bean
	public Mobiles getIPhoneObject(Color color) {
		return new IPhone(color);
	}
}
