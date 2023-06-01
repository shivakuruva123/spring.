package org.jsp1;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.jsp1")
public class UserConfi {
@Bean
public EntityManager getEntityManager() {
	return Persistence.createEntityManagerFactory("dev").createEntityManager();
}
}
