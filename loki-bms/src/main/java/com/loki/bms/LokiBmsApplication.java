package com.loki.bms;

import static com.loki.bms.utils.ApplicationConstants.*;

import com.loki.common.config.AuditConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Import({AuditConfiguration.class})
@ComponentScan({COMMON_PACKAGE, BMS_PACKAGE, CUSTOMER_PACKAGE, CONFIGURATION_PACKAGE, ITEM_PACKAGE, INVOICE_PACKAGE})
@EntityScan({CUSTOMER_ENTITY_PKG, CONFIG_ENTITY_PKG, ITEM_ENTITY_PKG, INVOICE_ENTITY_PACKAGE})
@EnableJpaRepositories({CUSTOMER_REPO_PKG, CONFIG_REPO_PKG, ITEM_REPO_PKG, INVOICE_REPO_PACKAGE})
public class LokiBmsApplication {

	private static final Logger logger = LoggerFactory.getLogger(LokiBmsApplication.class);

	private final Environment environment;

	public LokiBmsApplication(Environment environment) {
		this.environment = environment;
	}

	@PostConstruct
	public void initApplication() {
		logger.info("Loki Billing Management System Starting...");
	}

	public static void main(String[] args) {
        SpringApplication.run(LokiBmsApplication.class, args);
    }
}
