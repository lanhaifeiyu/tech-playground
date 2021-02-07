package com.lhfeiyu.tech.framework;

import io.lettuce.core.*;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.sync.NodeSelection;
import io.lettuce.core.cluster.api.sync.RedisAdvancedClusterCommands;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * TODO
 * https://juejin.im/post/5d8eb73ff265da5ba5329c66
 *
 * @author airson
 */
public class RedisLettuceDemo {

    public static void main(String[] args) {
        //redis_base();
        redis_cluster();
    }

    public static void redis_base() {
        RedisURI redisUri = RedisURI.builder()                    // <1> 创建单机连接的连接信息
                .withHost("172.81.216.81")
                .withPort(6380)
                .withPassword("vfr47ujm")
                .withTimeout(Duration.of(10, ChronoUnit.SECONDS))
                .build();
        RedisClient redisClient = RedisClient.create(redisUri);   // <2> 创建客户端
        StatefulRedisConnection<String, String> connection = redisClient.connect();     // <3> 创建线程安全的连接
        RedisCommands<String, String> redisCommands = connection.sync();                // <4> 创建同步命令
        SetArgs setArgs = SetArgs.Builder.nx().ex(5);
        String result = redisCommands.set("name", "throwable", setArgs);
        System.out.println(result);
        //Assertions.assertThat(result).isEqualToIgnoringCase("OK");
        result = redisCommands.get("clust1");
        //Assertions.assertThat(result).isEqualTo("throwable");

        System.out.println(result);

        // ... 其他操作
        connection.close();   // <5> 关闭连接
        redisClient.shutdown();  // <6> 关闭客户端


    }

    public static void redis_cluster() {
        RedisURI redisUri = RedisURI.builder()                    // <1> 创建单机连接的连接信息
                .withHost("172.81.216.81")
                .withPort(6380)
                .withPassword("vfr47ujm")
                .withTimeout(Duration.of(10, ChronoUnit.SECONDS))
                .build();
        //cluster
        RedisClusterClient redisClient = RedisClusterClient.create(redisUri);   // <2> 创建客户端
        StatefulRedisClusterConnection<String, String> connection = redisClient.connect();     // <3> 创建线程安全的连接
        RedisAdvancedClusterCommands<String, String> redisCommands = connection.sync();                // <4> 创建同步命令
        NodeSelection nodes = redisCommands.replicas();
        System.out.println("replicas:" + nodes.asMap().toString());
        //SetArgs setArgs = SetArgs.Builder.nx().ex(5);
        //String result = redisCommands.set("clust1", "throwable", setArgs);
        //System.out.println(result);
        //Assertions.assertThat(result).isEqualToIgnoringCase("OK");
        String result = redisCommands.get("clust1");
        //Assertions.assertThat(result).isEqualTo("throwable");
        System.out.println("clust1:" + result);
        // ... 其他操作

        /*redisCommands.sadd("key_set", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j");
        ScanArgs scanArgs = ScanArgs.Builder.limit(3);
        ValueScanCursor scan = new ValueScanCursor();
        scan.setCursor("0");
        do {
            scan = redisCommands.sscan("key_set", scan, scanArgs);
            System.out.println("set_scan:" + scan.getValues().toString() + ",index:" + scan.getCursor());
        } while (!scan.isFinished());
        */

        redisCommands.zadd("key_zset",
                ScoredValue.just(4, "d"),
                ScoredValue.just(2, "b"),
                ScoredValue.just(1, "a"),
                ScoredValue.just(3, "c"));

        ScanArgs scanArgs = ScanArgs.Builder.limit(3);
        ScoredValueScanCursor scan = new ScoredValueScanCursor();
        scan.setCursor("0");
        do {
            scan = redisCommands.zscan("key_zset", scan, scanArgs);
            System.out.println("zset_scan:" + scan.getValues().toString() + ",index:" + scan.getCursor());
        } while (!scan.isFinished());
        //redisCommands.zrangebyscore("key_zset", Range.from());

        SetArgs args = new SetArgs();
        args.ex(10).nx();
        redisCommands.set("setnxlock", "date_ts", args);

        //List<KeyValue<String, String>> kvList = redisCommands.mget("key_set");


        connection.close();   // <5> 关闭连接
        redisClient.shutdown();  // <6> 关闭客户端
    }

    public static void redis_cluster_types() {

    }

}
