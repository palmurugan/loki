package com.loki.customer.core;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan({"com.loki.common", "com.loki.customer"})
@EntityScan({"com.loki.customer.core.entity"})
@EnableJpaRepositories({"com.loki.customer.impl.repository"})
public class AppConfig {
}
