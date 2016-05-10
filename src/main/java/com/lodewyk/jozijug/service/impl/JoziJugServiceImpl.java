package com.lodewyk.jozijug.service.impl;

import org.springframework.stereotype.Service;
import com.lodewyk.jozijug.service.JoziJugService;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

@Service
public class JoziJugServiceImpl implements JoziJugService {
	
	private static final GpioPinDigitalOutput LED_PIN = GpioFactory.getInstance()
			.provisionDigitalOutputPin(RaspiPin.GPIO_01, "LED pin", PinState.LOW);

	
	public void toggleLed() {
		LED_PIN.toggle();
	}
}
