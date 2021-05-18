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
public class TreatmentDtoBffResponse implements Serializable {

    static final long serialVersionUID = 750793661435213024L;

    private UUID id;
    private UUID visitId;
    private MedicineDtoBffResponse medicine;
    private int concentrationQuantity;
    private AdministrationMethodDtoBffResponse administrationMethod;
    private int durationQuantity;
    private DurationDtoBffResponse duration;
    private String observations;

}
