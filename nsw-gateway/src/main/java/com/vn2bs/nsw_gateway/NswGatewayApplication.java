package com.vn2bs.nsw_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.vn2bs.common", "com.vn2bs.nsw_gateway" })
@EnableJpaAuditing
@EntityScan(basePackages = { "com.vn2bs.common.domains" })
@EnableJpaRepositories(basePackages = { "com.vn2bs.common.repositories" })
public class NswGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(NswGatewayApplication.class, args);
	}

}
