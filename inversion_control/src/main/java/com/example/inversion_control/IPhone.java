package com.example.inversion_control;

public class IPhone implements Mobiles {
	Color color;
	public IPhone(Color color) {
		this.color=color;
	}
	@Override
	public void getModelAndColor() {
		System.out.println("Model : 15+");
		color.getIPhoneColor();
	}

}
