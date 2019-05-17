package com.sgic.hrm.trainee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages= {"com.sgic.hrm.commons.entity.trainee"})
@EnableJpaRepositories(basePackages= {"com.sgic.hrm.commons.repository.trainee"})
public class HrmTraineeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmTraineeApplication.class, args);
	}
}
