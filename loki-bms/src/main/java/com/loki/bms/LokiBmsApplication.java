package com.loki.bms;

import static com.loki.bms.utils.ApplicationConstants.*;
import com.loki.common.config.AuditConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import({AuditConfiguration.class})
@ComponentScan({COMMON_PACKAGE, BMS_PACKAGE, CUSTOMER_PACKAGE, CONFIGURATION_PACKAGE, ITEM_PACKAGE})
@EntityScan({"com.loki.customer.core.entity", "com.loki.configuration.core.entity"})
@EnableJpaRepositories({"com.loki.customer.impl.repository",  "com.loki.configuration.impl.repository"})
public class LokiBmsApplication {

	public static final String ITEM_SERVICE_PACKAGE = "com.loki.item";

	public static void main(String[] args) {
		SpringApplication.run(LokiBmsApplication.class, args);
	}

}
