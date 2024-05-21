package org.example.middleware.dynamic.thread.pool.sdk.domain.model.valobj;

import lombok.Getter;

/**
 * @Classname RegistryEnumVO
 * @Description 注册中心枚举对象
 * @Author 魏弘宇
 * @Date 2024/5/21 12:44
 */
@Getter
public enum RegistryEnumVO {

    THREAD_POOL_CONFIG_LIST_KEY("THREAD_POOL_CONFIG_LIST_KEY", "池化配置列表"),
    THREAD_POOL_CONFIG_PARAMETER_LIST_KEY("THREAD_POOL_CONFIG_PARAMETER_LIST_KEY", "池化配置参数"),
    DYNAMIC_THREAD_POOL_REDIS_TOPIC("DYNAMIC_THREAD_POOL_REDIS_TOPIC", "动态线程池监听主题配置");

    private final String key;
    private final String desc;

    RegistryEnumVO(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

}
