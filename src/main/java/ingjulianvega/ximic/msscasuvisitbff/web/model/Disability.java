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
public class Disability implements Serializable {

    static final long serialVersionUID = -710271998756822949L;

    private UUID visitId;
    private UUID disabilityTypeId;
    private int durationQuantity;
    private UUID durationId;
    private String observations;

}
