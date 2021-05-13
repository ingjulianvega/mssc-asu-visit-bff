package ingjulianvega.ximic.msscasuvisitbff.configuration;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJms
@EnableTransactionManagement
@Configuration
@Slf4j
public class JmsConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Value("${spring.activemq.user}")
    private String user;

    @Value("${spring.activemq.password}")
    private String password;

    public static final String UPDATE_VISIT_QUEUE = "update-visit";
    public static final String UPDATE_SYSTEM_CHECK_QUEUE = "update-system-check";
    public static final String UPDATE_BODY_CHECK_QUEUE = "update-body-check";
    public static final String UPDATE_TREATMENT_QUEUE = "update-treatment";
    public static final String UPDATE_RECOMMENDATION_QUEUE = "update-recommendation";
    public static final String UPDATE_REMISSION_QUEUE = "update-remission";
    public static final String UPDATE_DISABILITY_QUEUE = "update-disability";

    @Bean
    public MessageConverter jacksonJmsMessageConverter() {


        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }


    @Bean
    public CachingConnectionFactory connectionFactory() {

        CachingConnectionFactory factory = new CachingConnectionFactory(
                new ActiveMQConnectionFactory(user, password, brokerUrl)
        );
        factory.setClientId("StoreFront");
        factory.setSessionCacheSize(100);
        return factory;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setMessageConverter(jacksonJmsMessageConverter());
        factory.setTransactionManager(jmsTransactionManager());
        factory.setErrorHandler(t -> {
            log.info("Handling error in listening for messages, error: " + t.getMessage());
        });
        return factory;
    }

    @Bean
    public PlatformTransactionManager jmsTransactionManager(){
        return new JmsTransactionManager(connectionFactory());
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
        jmsTemplate.setMessageConverter(jacksonJmsMessageConverter());
        jmsTemplate.setDeliveryPersistent(true);
        jmsTemplate.setSessionTransacted(true);
        return jmsTemplate;

    }
}
