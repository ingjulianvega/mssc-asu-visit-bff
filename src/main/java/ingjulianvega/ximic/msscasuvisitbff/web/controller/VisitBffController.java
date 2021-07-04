package ingjulianvega.ximic.msscasuvisitbff.web.controller;


import ingjulianvega.ximic.msscasuvisitbff.services.VisitBffService;
import ingjulianvega.ximic.msscasuvisitbff.web.model.Visit;
import ingjulianvega.ximic.msscasuvisitbff.web.model.response.DetailedVisitResponse;
import ingjulianvega.ximic.msscasuvisitbff.web.model.response.SummaryVisitListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class VisitBffController implements VisitBffI {

    private final VisitBffService visitBffService;

    @Override
    public ResponseEntity<SummaryVisitListResponse> getSummaryByPatientId(UUID patientId) {
        return new ResponseEntity<>(visitBffService.getSummaryByPatientId(patientId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SummaryVisitListResponse> getSummaryByDate(OffsetDateTime date) {
        return new ResponseEntity<>(visitBffService.getSummaryByDate(date), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SummaryVisitListResponse> getSummaryByDisease(UUID diseaseId) {
        return new ResponseEntity<>(visitBffService.getSummaryByDisease(diseaseId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DetailedVisitResponse> getDetailById(UUID id) {
        return new ResponseEntity<>(visitBffService.getDetailById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateById(UUID id, Visit visit) {
        visitBffService.updateById(id, visit);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
