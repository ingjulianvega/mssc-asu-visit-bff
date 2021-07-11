package ingjulianvega.ximic.msscasuvisitbff.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "visit-bff")
public class VisitBffParameters {

    private String api;
}
