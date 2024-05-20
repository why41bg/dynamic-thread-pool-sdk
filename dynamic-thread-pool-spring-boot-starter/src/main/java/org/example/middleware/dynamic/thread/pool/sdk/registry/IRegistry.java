package org.example.middleware.dynamic.thread.pool.sdk.registry;

import org.example.middleware.dynamic.thread.pool.sdk.domain.model.entity.ThreadPoolConfigEntity;

import java.util.List;

/**
 * @className: IRegistry
 * @description: TODO 类描述
 * @author: 魏弘宇
 * @date: 2024/5/21
 **/
public interface IRegistry {

    void reportAllThreadPoolConfig(List<ThreadPoolConfigEntity> threadPoolEntities);

    void reportSingleThreadPoolConfig(ThreadPoolConfigEntity threadPoolConfigEntity);

}
