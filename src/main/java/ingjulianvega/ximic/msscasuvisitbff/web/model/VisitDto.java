package ingjulianvega.ximic.msscasuvisitbff.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VisitDto implements Serializable {

    static final long serialVersionUID = 6606325408615152490L;

    private UUID id;
    private UUID patientId;
    private UUID companionId;
    private UUID visitTypeId;
    private UUID billingId;
    private String reason;
    private int height;
    private int systolicBloodPressure;
    private int diastolicBloodPressure;
    private int weight;
    private int heartRate;
    private float temperature;
    private UUID diseaseId;
    private String observations;
    private OffsetDateTime createdDate;

    private SystemCheckList systemCheckList;
    private BodyCheckList bodyCheckList;
    private TreatmentList treatmentList;
    private RecommendationList recommendationList;
    private DisabilityList disabilityList;
    private RemissionList remissionList;

}