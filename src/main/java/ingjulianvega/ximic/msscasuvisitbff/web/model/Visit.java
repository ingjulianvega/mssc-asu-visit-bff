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
public class Visit implements Serializable {

    static final long serialVersionUID = -2894452328770257905L;

    private UUID patientId;
    private UUID companionId;
    private UUID visitTypeId;
    private UUID billingId;
    private UUID diseaseId;
    private String reason;
    private int height;
    private int systolicBloodPressure;
    private int diastolicBloodPressure;
    private int weight;
    private int heartRate;
    private float temperature;
    private String observations;

    private SystemCheckList systemCheckList;
    private BodyCheckList bodyCheckList;
    private TreatmentList treatmentList;
    private RecommendationList recommendationList;
    private DisabilityList disabilityList;
    private RemissionList remissionList;

}
