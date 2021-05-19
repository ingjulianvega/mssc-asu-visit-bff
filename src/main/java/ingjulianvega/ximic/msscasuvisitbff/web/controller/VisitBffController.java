package ingjulianvega.ximic.msscasuvisitbff.web.controller;


import ingjulianvega.ximic.msscasuvisitbff.services.VisitBffService;
import ingjulianvega.ximic.msscasuvisitbff.web.model.Visit;
import ingjulianvega.ximic.msscasuvisitbff.web.model.VisitListBffResponse;
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
    public ResponseEntity<VisitListBffResponse> getSummaryByPatientId(UUID patientId) {
        return new ResponseEntity<>(visitBffService.getSummaryByPatientId(patientId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VisitListBffResponse> getSummaryByDate(OffsetDateTime date) {
        return new ResponseEntity<>(visitBffService.getSummaryByDate(date), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VisitListBffResponse> getSummaryByDisease(UUID diseaseId) {
        return new ResponseEntity<>(visitBffService.getSummaryByDisease(diseaseId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VisitListBffResponse> getDetailById(UUID id) {
        return new ResponseEntity<>(visitBffService.getDetailById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateById(UUID id, Visit visit) {
        visitBffService.updateById(id, visit);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteById(@NotNull UUID id) {
        visitBffService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
