package com.tang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication(scanBasePackages = {"com.tang"})
@EnableAsync
public class SpringBootTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestApplication.class, args);
	}


	@Configuration
	class TaskPoolConfig{

		/**
		 * 定义一个spring线程池
		 * @return
		 */
		@Bean
		public TaskExecutor threadPoolTaskExecutor(){
			ThreadPoolTaskExecutor tpte = new ThreadPoolTaskExecutor();
			tpte.setCorePoolSize(20);
			tpte.setMaxPoolSize(100);
			tpte.setKeepAliveSeconds(3000);
			tpte.setQueueCapacity(100);
			tpte.setThreadNamePrefix("Thread-Pool-Task-");
			tpte.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
			return tpte;
		}

	}

}
