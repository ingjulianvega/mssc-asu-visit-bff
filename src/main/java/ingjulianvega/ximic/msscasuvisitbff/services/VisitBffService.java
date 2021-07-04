package ingjulianvega.ximic.msscasuvisitbff.services;


import ingjulianvega.ximic.msscasuvisitbff.web.model.Visit;
import ingjulianvega.ximic.msscasuvisitbff.web.model.response.DetailedVisitResponse;
import ingjulianvega.ximic.msscasuvisitbff.web.model.response.SummaryVisitListResponse;

import java.time.OffsetDateTime;
import java.util.UUID;

public interface VisitBffService {

    SummaryVisitListResponse getSummaryByPatientId(UUID patientId);

    SummaryVisitListResponse getSummaryByDate(OffsetDateTime date);

    SummaryVisitListResponse getSummaryByDisease(UUID diseaseId);

    DetailedVisitResponse getDetailById(UUID id);

    void updateById(UUID id, Visit visit);

}
