package ingjulianvega.ximic.msscasuvisitbff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsscAsuVisitBffApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsscAsuVisitBffApplication.class, args);
	}

}
