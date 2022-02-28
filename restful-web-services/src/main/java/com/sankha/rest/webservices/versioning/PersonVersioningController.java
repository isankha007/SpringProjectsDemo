package com.sankha.rest.webservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	@GetMapping("v1/person")
	public PersonV0 personv0() {
		return new PersonV0("Sankha");
	}
	@GetMapping(value="/person/param",params = "version=1")
	public PersonV0 paramv0() {
		return new PersonV0("Sankha");
	}
	
	@GetMapping(value="/person/param",params = "version=2")
	public PersonV1 paramv2() {
		return new PersonV1(new Name("Sankha","Chatterjee"));
	}

}
