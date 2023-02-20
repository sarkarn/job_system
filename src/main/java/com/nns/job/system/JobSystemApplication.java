/**
 * 
 */
package com.nns.job.system;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author eostermueller@gmail.com
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.nns.job.system"})
public class JobSystemApplication extends SpringBootServletInitializer {

	
	public static void main(String[] args) {
		SpringApplication.run(JobSystemApplication.class, args);

	}

}
