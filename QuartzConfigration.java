package com.xayy.employee.config;

import com.xayy.employee.service.impl.ScheduledTasks;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Created by Administrator on 2018/6/23.
 */
@Configuration
public class QuartzConfigration {


    // 配置定时任务
    @Bean(name = "scheduledDetail")
    public MethodInvokingJobDetailFactoryBean scheduledDetail(ScheduledTasks scheduledTasks) {
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        // 是否并发执行
        jobDetail.setConcurrent(false);
        // 为需要执行的实体类对应的对象
        jobDetail.setTargetObject(scheduledTasks);
        // 需要执行的方法
        jobDetail.setTargetMethod("execute");
        return jobDetail;
    }

    // 配置触发器
    @Bean(name = "scheduledTrigger")
    public CronTriggerFactoryBean scheduledTrigger(JobDetail secondJobDetail) {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(secondJobDetail);
        // cron表达式
        trigger.setCronExpression("0 0-59 17 * * ?");
        return trigger;
    }

    // 配置Scheduler
    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactory(Trigger secondTrigger) {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        // 延时启动，应用启动1秒后
        bean.setStartupDelay(1);
        // 注册触发器
        bean.setTriggers(secondTrigger);
        return bean;
    }

}
