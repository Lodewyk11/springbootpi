package com.lodewyk.jozijug.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lodewyk.jozijug.service.JoziJugService;
import io.swagger.annotations.ApiOperation;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class JoziJugController {
	
	@Autowired
	private JoziJugService joziJugService;
	
	@RequestMapping(path = "/toggleLed", method = POST, produces = "application/json")
	@ApiOperation(value = "Toggle LED", notes="Toggles the LED on connected to the Raspberry Pi")
	public void toggleLed() {
		joziJugService.toggleLed();
	}
}
