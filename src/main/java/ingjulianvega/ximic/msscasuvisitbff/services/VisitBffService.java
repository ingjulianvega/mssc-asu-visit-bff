package ingjulianvega.ximic.msscasuvisitbff.services;


import ingjulianvega.ximic.msscasuvisitbff.web.model.Visit;
import ingjulianvega.ximic.msscasuvisitbff.web.model.VisitDto;
import ingjulianvega.ximic.msscasuvisitbff.web.model.VisitList;

import java.time.OffsetDateTime;
import java.util.UUID;

public interface VisitBffService {

    VisitList getSummaryByPatientId(UUID patientId);

    VisitList getSummaryByDate(OffsetDateTime date);

    VisitList getSummaryByDisease(UUID diseaseId);

    VisitDto getDetailById(UUID id);

    void updateById(UUID id, Visit visit);

    void deleteById(UUID id);
}
