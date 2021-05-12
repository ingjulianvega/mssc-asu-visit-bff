package ingjulianvega.ximic.msscasuvisitbff.configuration;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@EnableJms
@Configuration
public class JmsConfig {

    @Value("${active-mq.user}")
    private String user;

    @Value("${active-mq.password}")
    private String password;

    public static final String UPDATE_VISIT_QUEUE = "update-visit";
    public static final String UPDATE_SYSTEM_CHECK_QUEUE = "update-system-check";
    public static final String UPDATE_BODY_CHECK_QUEUE = "update-body-check";
    public static final String UPDATE_TREATMENT_QUEUE = "update-treatment";
    public static final String UPDATE_RECOMMENDATION_QUEUE = "update-recommendation";
    public static final String UPDATE_REMISSION_QUEUE = "update-remission";
    public static final String UPDATE_DISABILITY_QUEUE = "update-disability";

    @Bean
    public MessageConverter jacksonJmsMessageConverter(){
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("admin","admin","tcp://localhost:61616");
        return factory;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setMessageConverter(jacksonJmsMessageConverter());
        return factory;
    }
}
