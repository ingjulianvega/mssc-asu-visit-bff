package ingjulianvega.ximic.msscasuvisitbff.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;

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
    public ConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory activeMQConnectionFactory  = new ActiveMQConnectionFactory();
        //activeMQConnectionFactory.setBrokerURL(brokerUrl);
        //activeMQConnectionFactory.setTrustedPackages(Arrays.asList("com.mailshine.springbootstandaloneactivemq"));
        activeMQConnectionFactory.setPassword(password);
        activeMQConnectionFactory.setUser(user);
        return  activeMQConnectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setPubSubDomain(true);  // enable for Pub Sub to topic. Not Required for Queue.
        return jmsTemplate;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setPubSubDomain(true);
        return factory;
    }

    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter(ObjectMapper objectMapper) {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        converter.setObjectMapper(objectMapper);
        return converter;
    }
}
