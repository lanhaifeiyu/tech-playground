package com.lhfeiyu.tech.framework;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.*;

/**
 * TODO
 *
 * @author airson
 */
public class RedisDemo {

    public static void main(String[] args) {
        //redis_base();
        redis_cluster();
    }

    public static void redis_base() {
        Jedis jedis = new Jedis("172.81.216.81");
        jedis.auth("vfr47ujm");
        jedis.set("jedisstr", "jedisstr foo bar");
        String value = jedis.get("jedisstr");
        //System.out.println(jedis.keys("*"));
        System.out.println(jedis.lrange("mylist", 0, -1));
        System.out.println(value);

        //create a pipeline
        Pipeline pipeline = jedis.pipelined();
        pipeline.set("pipe1", "pipeval1");
        pipeline.set("pipe2", "pipeval2");
        pipeline.set("pipe3", "pipeval3");
        Response<String> stringResponse = pipeline.get("pipe2");
        //send
        pipeline.sync();
        //handle response
        System.out.println(stringResponse.get());
    }

    public static void redis_cluster() {
        //Jedis: Exception in thread "main" redis.clients.jedis.exceptions.JedisMovedDataException: MOVED 7816 10.2.0.22:6380
        //public JedisCluster(HostAndPort node, int connectionTimeout, int soTimeout,
        //      int maxAttempts, String password, final GenericObjectPoolConfig poolConfig) {
        HostAndPort ipport = new HostAndPort("172.81.216.81", 6380);
        //Jedis jedis = new Jedis(ipport);//
        JedisCluster jedis = new JedisCluster(ipport, 2000, 2000, 2, "vfr47ujm", new GenericObjectPoolConfig());
        //jedis.auth("vfr47ujm");
        String value = jedis.get("clust1");
        System.out.println(value);
    }

}
