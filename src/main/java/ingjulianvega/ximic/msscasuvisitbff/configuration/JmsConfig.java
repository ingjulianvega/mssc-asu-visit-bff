package ingjulianvega.ximic.msscasuvisitbff.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;

import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsConfig {

    public static final String UPDATE_VISIT_QUEUE = "update-visit";
    public static final String UPDATE_SYSTEM_CHECK_QUEUE = "update-system-check";
    public static final String UPDATE_BODY_CHECK_QUEUE = "update-body-check";
    public static final String UPDATE_TREATMENT_QUEUE = "update-treatment";
    public static final String UPDATE_RECOMMENDATION_QUEUE = "update-recommendation";
    public static final String UPDATE_REMISSION_QUEUE = "update-remission";
    public static final String UPDATE_DISABILITY_QUEUE = "update-disability";


    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter(ObjectMapper objectMapper) {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        converter.setObjectMapper(objectMapper);
        return converter;
    }
}
