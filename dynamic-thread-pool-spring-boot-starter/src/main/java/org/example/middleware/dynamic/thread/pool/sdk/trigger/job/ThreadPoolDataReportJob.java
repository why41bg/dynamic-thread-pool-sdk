package org.example.middleware.dynamic.thread.pool.sdk.trigger.job;

import com.alibaba.fastjson.JSON;
import org.example.middleware.dynamic.thread.pool.sdk.domain.DynamicThreadPoolService;
import org.example.middleware.dynamic.thread.pool.sdk.domain.IDynamicThreadPoolService;
import org.example.middleware.dynamic.thread.pool.sdk.domain.model.entity.ThreadPoolConfigEntity;
import org.example.middleware.dynamic.thread.pool.sdk.registry.IRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/**
 * @Classname ThreadPoolDataReportJob
 * @Description 线程池配置数据上报任务
 * @Author 魏弘宇
 * @Date 2024/5/21 01:14
 */
public class ThreadPoolDataReportJob {

    private final Logger logger = LoggerFactory.getLogger(ThreadPoolDataReportJob.class);

    private final IDynamicThreadPoolService dynamicThreadPoolService;

    private final IRegistry registry;

    public ThreadPoolDataReportJob(IDynamicThreadPoolService dynamicThreadPoolService, IRegistry registry) {
        this.dynamicThreadPoolService = dynamicThreadPoolService;
        this.registry = registry;
    }

    @Scheduled(cron = "0/20 * * * * ?")  // 每20秒执行一次
    public void reportThreadPoolData() {
        List<ThreadPoolConfigEntity> allThreadPoolConfig = dynamicThreadPoolService.getAllThreadPoolConfig();
        registry.reportAllThreadPoolConfig(allThreadPoolConfig);
        logger.info("动态线程池，上报线程池信息：{}", JSON.toJSONString(allThreadPoolConfig));

        for (ThreadPoolConfigEntity threadPoolConfigEntity : allThreadPoolConfig) {
            registry.reportSingleThreadPoolConfig(threadPoolConfigEntity);
            logger.info("动态线程池，上报单个线程池信息：{}", JSON.toJSONString(threadPoolConfigEntity));
        }
    }
}
