package com.test.bankingPrototype.health;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class healthCheck {

	static Logger LOG = LoggerFactory.getLogger(healthCheck.class);

	@ResponseBody
	@RequestMapping("/health")
	public Map<String, String> health() {
		// Return map to let user know the service is active
		Map<String, String> map = new HashMap<>();
		map.put("status", "200");
		map.put("body", "This is a health check response from the Banking Prototyping Project!");
		return map;
	}

	@ResponseBody
	@RequestMapping("/logging")
	public Map<String, String> logging() {
		// Test logging functionality
		LOG.trace("A TRACE Message from the Health Endpoint");
		LOG.debug("A DEBUG Message from the Health Endpoint");
		LOG.info("An INFO Message from the Health Endpoint");
		LOG.warn("A WARN Message from the Health Endpoint");
		LOG.error("An ERROR Message from the Health Endpoint");

		// Return map to let user know the logging is active
		Map<String, String> map = new HashMap<>();
		map.put("status", "200");
	    return map;
	}
}
