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
public class RemissionDtoBffResponse implements Serializable {

    static final long serialVersionUID = -2398880207866040229L;

    private UUID id;
    private UUID visitId;
    private RemissionTypeDtoBffResponse remissionType;
    private String observations;

}
