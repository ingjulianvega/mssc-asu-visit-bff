package ingjulianvega.ximic.msscasuvisitbff.web.model.response;

import ingjulianvega.ximic.msscasuvisitbff.web.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailedVisitResponse {

    private PatientDtoBffResponse patient;
    private CompanionDtoBffResponse companion;
    private VisitTypeDto visit;
    private BillingDto billing;
    private DiseaseDto disease;
    private String reason;
    private int height;
    private int systolicBloodPressure;
    private int diastolicBloodPressure;
    private int weight;
    private int heartRate;
    private float temperature;
    private String observations;

    private SystemCheckListBffResponse systemCheckList;
    private BodyCheckListBffResponse bodyCheckList;
    private TreatmentListBffResponse treatmentList;
    private RecommendationListBffResponse recommendationList;
    private DisabilityListBffResponse disabilityList;
    private RemissionListBffResponse remissionList;

}
