package com.challenge.pricerest.infrastructure.db.springdata.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableJpaRepositories(basePackages = "com.challenge.pricerest.infrastructure.db.springdata.repository")
@ConfigurationProperties("spring.datasource")
@Slf4j
@NoArgsConstructor
@Data
@EnableJpaAuditing
@EntityScan(basePackages = "com.challenge.pricerest.infrastructure.db.springdata.dbo")
public class SpringDataConfig
{

}
