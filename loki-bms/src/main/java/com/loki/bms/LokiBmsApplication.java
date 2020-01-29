package com.loki.bms;

import com.loki.common.config.AuditConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import({AuditConfiguration.class})
@ComponentScan({"com.loki.common", "com.loki.customer"})
@EntityScan({"com.loki.customer.core.entity"})
@EnableJpaRepositories({"com.loki.customer.impl.repository"})
public class LokiBmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LokiBmsApplication.class, args);
	}

}
