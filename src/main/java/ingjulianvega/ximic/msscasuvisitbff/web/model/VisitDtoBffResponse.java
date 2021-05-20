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
public class VisitDtoBffResponse implements Serializable {

    static final long serialVersionUID = 6606325408615152490L;

    private UUID id;
    private PatientDtoBffResponse patient;
    private CompanionDto companion;
    private VisitTypeDto visitType;
    private BillingDto billing;
    private String reason;
    private int height;
    private int systolicBloodPressure;
    private int diastolicBloodPressure;
    private int weight;
    private int heartRate;
    private float temperature;
    private DiseaseDto disease;
    private String observations;
    private OffsetDateTime createdDate;

    private SystemCheckListBffResponse systemCheckList;
    private BodyCheckListBffResponse bodyCheckList;
    private TreatmentListBffResponse treatmentList;
    private RecommendationListBffResponse recommendationList;
    private DisabilityListBffResponse disabilityList;
    private RemissionListBffResponse remissionList;

}