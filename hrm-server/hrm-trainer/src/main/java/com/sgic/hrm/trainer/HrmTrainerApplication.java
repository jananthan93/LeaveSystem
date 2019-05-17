package com.sgic.hrm.trainer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages= {"com.sgic.hrm.commons.entity"})
@EnableJpaRepositories(basePackages= {"com.sgic.hrm.commons.trainer.repository","com.sgic.hrm.commons.repository"})

public class HrmTrainerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmTrainerApplication.class, args);
	}
}
