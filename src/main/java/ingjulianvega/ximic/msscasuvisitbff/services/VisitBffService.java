package ingjulianvega.ximic.msscasuvisitbff.services;


import ingjulianvega.ximic.msscasuvisitbff.web.model.Visit;
import ingjulianvega.ximic.msscasuvisitbff.web.model.VisitDto;
import ingjulianvega.ximic.msscasuvisitbff.web.model.VisitListBffResponse;

import java.time.OffsetDateTime;
import java.util.UUID;

public interface VisitBffService {

    VisitListBffResponse getSummaryByPatientId(UUID patientId);

    VisitListBffResponse getSummaryByDate(OffsetDateTime date);

    VisitListBffResponse getSummaryByDisease(UUID diseaseId);

    VisitDto getDetailById(UUID id);

    void updateById(UUID id, Visit visit);

    void deleteById(UUID id);
}
