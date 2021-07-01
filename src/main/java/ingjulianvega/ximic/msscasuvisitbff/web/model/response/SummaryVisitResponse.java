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
public class SummaryVisitResponse {

    private PatientDtoBffResponse patient;
    private VisitTypeDto visit;
    private BillingDto billing;
    private DiseaseDto disease;
    private String reason;
    private String observations;

    private RemissionListBffResponse remissionList;

}
