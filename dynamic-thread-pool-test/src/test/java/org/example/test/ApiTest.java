package org.example.test;

import lombok.extern.slf4j.Slf4j;
import org.example.middleware.dynamic.thread.pool.sdk.domain.model.entity.ThreadPoolConfigEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    @Autowired
    private RTopic topic;

    @Test
    public void testThreadPoolConfigPublish() throws InterruptedException {
        ThreadPoolConfigEntity threadPoolConfigEntity = new ThreadPoolConfigEntity("dynamic-thread-pool-test-app", "threadPoolExecutor01");
        threadPoolConfigEntity.setCorePoolSize(10);
        threadPoolConfigEntity.setMaximumPoolSize(100);
        topic.publish(threadPoolConfigEntity);

        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }

}
