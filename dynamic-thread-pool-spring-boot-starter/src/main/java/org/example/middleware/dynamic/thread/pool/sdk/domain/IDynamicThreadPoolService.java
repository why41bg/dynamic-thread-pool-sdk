package org.example.middleware.dynamic.thread.pool.sdk.domain;

import org.example.middleware.dynamic.thread.pool.sdk.domain.model.entity.ThreadPoolConfigEntity;

import java.util.List;

/**
 * @className: IDynamicThreadPoolService
 * @description: 动态线程池服务接口
 * @author: 魏弘宇
 * @date: 2024/5/20
 **/
public interface IDynamicThreadPoolService {

    List<ThreadPoolConfigEntity> getAllThreadPoolConfig();

    ThreadPoolConfigEntity getThreadPoolConfigByName(String threadPoolName);

    void updateThreadPoolConfig(ThreadPoolConfigEntity threadPoolConfigEntity);
}
