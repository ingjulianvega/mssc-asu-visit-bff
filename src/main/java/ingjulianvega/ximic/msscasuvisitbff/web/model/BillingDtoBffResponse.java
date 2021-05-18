package ingjulianvega.ximic.msscasuvisitbff.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillingDtoBffResponse implements Serializable {

    static final long serialVersionUID = 6590046323118692119L;

    private UUID id;
    private String paymentMethod;
    private int quantity;

}