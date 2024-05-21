package org.example.middleware.dynamic.thread.pool.sdk.trigger.listener;

import com.alibaba.fastjson.JSON;
import org.example.middleware.dynamic.thread.pool.sdk.domain.IDynamicThreadPoolService;
import org.example.middleware.dynamic.thread.pool.sdk.domain.model.entity.ThreadPoolConfigEntity;
import org.example.middleware.dynamic.thread.pool.sdk.registry.IRegistry;
import org.redisson.api.listener.MessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Classname ThreadPoolConfigAdjustListener
 * @Description 线程池配置调整监听器
 * @Author 魏弘宇
 * @Date 2024/5/21 09:04
 */
public class ThreadPoolConfigAdjustListener implements MessageListener<ThreadPoolConfigEntity> {

    private final Logger logger = LoggerFactory.getLogger(ThreadPoolConfigAdjustListener.class);

    private final IDynamicThreadPoolService dynamicThreadPoolService;

    private final IRegistry registry;

    public ThreadPoolConfigAdjustListener(IDynamicThreadPoolService dynamicThreadPoolService, IRegistry registry) {
        this.dynamicThreadPoolService = dynamicThreadPoolService;
        this.registry = registry;
    }

    @Override
    public void onMessage(CharSequence charSequence, ThreadPoolConfigEntity threadPoolConfigEntity) {
        logger.info("监听到线程池配置变化。线程池名称:{} 核心线程数:{} 最大线程数:{}", threadPoolConfigEntity.getThreadPoolName(), threadPoolConfigEntity.getCorePoolSize(), threadPoolConfigEntity.getMaximumPoolSize());
        dynamicThreadPoolService.updateThreadPoolConfig(threadPoolConfigEntity);

        // 上报线程池配置
        List<ThreadPoolConfigEntity> allThreadPoolConfig = dynamicThreadPoolService.getAllThreadPoolConfig();
        registry.reportAllThreadPoolConfig(allThreadPoolConfig);
        logger.info("动态线程池，上报线程池信息：{}", JSON.toJSONString(allThreadPoolConfig));
        ThreadPoolConfigEntity threadPoolConfigCurr = dynamicThreadPoolService.getThreadPoolConfigByName(threadPoolConfigEntity.getThreadPoolName());
        registry.reportSingleThreadPoolConfig(threadPoolConfigCurr);
        logger.info("动态线程池，上报线程池配置：{}", JSON.toJSONString(threadPoolConfigCurr));
    }
}
