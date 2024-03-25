package com.education.education.microServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.education.education.models.Manager;

@FeignClient(url="http://localhost:8041", value = "Marketing-Client")
public interface MarketingClinet {
	
	@GetMapping("marketing/getManaget/{managerId}")
	Manager getManager(@PathVariable long managerId);
	

}
