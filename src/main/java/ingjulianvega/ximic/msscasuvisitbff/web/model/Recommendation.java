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
public class Recommendation implements Serializable {

    static final long serialVersionUID = -6098757405247407269L;

    private UUID visitId;
    private UUID recommendationTypeId;
    private String observations;

}
