package com.logging.kingmj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class SchedulerConfiguration implements SchedulingConfigurer {

    private static final int THREAD_POOL_SIZE = 5;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setTaskScheduler(setThreadPoolTaskScheduler());
    }

    private ThreadPoolTaskScheduler setThreadPoolTaskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(THREAD_POOL_SIZE);
        scheduler.setThreadNamePrefix("[Thread]");
        scheduler.initialize();

        return scheduler;
    }
}
