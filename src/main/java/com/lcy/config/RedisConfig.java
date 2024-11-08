//package com.lcy.config;
//
//import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.listener.PatternTopic;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import java.nio.charset.Charset;
//import java.time.Duration;
//
///**
// **
// ** @author dongguojie
// *
// ** @date 2021年5月20日
// */
//
//@Configuration
//public class RedisConfig {
//
//
//
//
//	@Value("${spring.redis.ls.host}")
//	private String lsHost;
//
//	@Value("${spring.redis.ls.port}")
//	private int lsPort;
//
//	@Value("${spring.redis.ls.password}")
//	private String lsPassword;
//
//	@Value("${spring.redis.ls.maxIdle}")
//	private int lsMaxIdle;
//
//	@Value("${spring.redis.ls.minIdle}")
//	private int lsMinIdle;
//
//	@Value("${spring.redis.ls.maxActive}")
//	private int lsMaxActive;
//
//	@Value("${spring.redis.ls.timeout}")
//	private int lsTimeout;
//
//	@Value("${spring.redis.ls.index}")
//	private int lsIndex;
//
//
//	@Bean
//	public RedisConnectionFactory connectionFactory() {
//
//		RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(lsHost, lsPort);
//		configuration.setPassword(lsPassword);
//		configuration.setDatabase(lsIndex);
//
//		GenericObjectPoolConfig poolConf = new GenericObjectPoolConfig();
//		poolConf.setMaxIdle(lsMaxIdle);
//		poolConf.setMaxTotal(lsMaxIdle);
//		poolConf.setMinIdle(lsMinIdle);
//		poolConf.setMaxWait(Duration.ofMillis(lsMaxActive));
//		poolConf.setTestOnBorrow(false);
//		poolConf.setTestOnReturn(false);
//
//		LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder builder = LettucePoolingClientConfiguration.builder();
//		builder.poolConfig(poolConf);
//
//		LettuceConnectionFactory factory = new LettuceConnectionFactory(configuration,builder.build());
//		factory.afterPropertiesSet();
//		return factory;
//	}
//
//
//
//	@Bean
//	public StringRedisTemplate redisTemplate(RedisConnectionFactory connectionFactory) {
//		StringRedisTemplate template = new StringRedisTemplate();
//		template.setConnectionFactory(connectionFactory);
//		return template;
//	}
//
//
//
//	@Autowired
//	private SendRobotWebMsgListener robotListener;
//
//
//    public MessageListenerAdapter robotListenerAdapter() {
//  		// 查找 SendWebMsgListener 里的onMessage方法处理
//	   return new MessageListenerAdapter(robotListener);
//	}
//
//
//
//
//	@Value("${redis.topic.mtc:to_mtc_web_msg}")
//	private String toMtcWebMsg;
//
//
//	@Value("${redis.topic.mtc:ls_sync_msg}")
//	private String lsSyncMsg;
//
//	@Value("${app.redis.topic.robot:to_robot_web_msg}")
//	private String toRobotWebMsg;
//
//	@Value("${app.redis.topic.bmop:to_bmop_web_msg}")
//	private String toBmopWebMsg;
//
//
//	@Value("${redis.topic.mtc:to_raim_web_msg}")
//	private String toRaimWebMsg;
//
//
//	@Bean
//	public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory){
//
//		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//	    container.setConnectionFactory(connectionFactory);
//	    //订阅多个频道
////	    container.addMessageListener(webListenerAdapter(),new PatternTopic(toMtcWebMsg));
////	    container.addMessageListener(lsSyncbListenerAdapter(),new PatternTopic(lsSyncMsg));
////	    container.addMessageListener(robotListenerAdapter(),new PatternTopic(toRobotWebMsg));
////	    container.addMessageListener(raimListenerAdapter(),new PatternTopic(toRaimWebMsg));
////	    container.addMessageListener(bmopListenerAdapter(),new PatternTopic(toBmopWebMsg));
////	    StringRedisSerializer seria = new StringRedisSerializer(Charset.forName("UTF-8"));
////	    container.setTopicSerializer(seria);
//	    return container;
//	}
//
//
//}
