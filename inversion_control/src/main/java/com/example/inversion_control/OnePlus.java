package com.example.inversion_control;

public class OnePlus implements Mobiles {
	Color color;
	public OnePlus(Color color) {
		this.color=color;
	}
	@Override
	public void getModelAndColor() {
		System.out.println("Model : 9 Pro");
		color.getOnePlusColor();
	}

}
