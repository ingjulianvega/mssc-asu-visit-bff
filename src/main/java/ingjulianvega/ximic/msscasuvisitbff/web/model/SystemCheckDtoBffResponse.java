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
public class SystemCheckDtoBffResponse implements Serializable {

    static final long serialVersionUID = 7387638237575102353L;

    private UUID visitId;
    private SystemDto system;
    private SymptomDto symptom;
    private IntensityDto intensity;
    private String observations;

}
