package au.com.telstra.simcardactivator.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import au.com.telstra.simcardactivator.dto.ActuatorDto;
import au.com.telstra.simcardactivator.dto.ActuatorResponseDto;
import au.com.telstra.simcardactivator.dto.RequestDto;
@Service
public class SimCardActivatorService {

	public RestTemplate restTemplate;

	public SimCardActivatorService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}
	
	public String request(RequestDto dto) {
		ActuatorDto actuatorDto=new ActuatorDto(dto.getIccid());
		ActuatorResponseDto responseDto= restTemplate.postForEntity("http://localhost:8444/actuate", actuatorDto, ActuatorResponseDto.class).getBody();
		if(responseDto.isSuccess()) {
			return "Successful";
		}
		else {
			return "Unsuccessful";
		}
	}
	
}
