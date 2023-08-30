package com.example.doanbanquanao.configurtion;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories("com.example.doanbanquanao")
@Configuration
public class PersistenceConfiguration {

}
