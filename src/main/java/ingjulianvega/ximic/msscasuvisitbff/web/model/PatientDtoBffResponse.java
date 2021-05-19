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
public class PatientDtoBffResponse implements Serializable {

    static final long serialVersionUID = -5560354705447607394L;

    private UUID id;
    private DocumentTypeDto documentType;
    private String documentNumber;
    private String name;
    private String firstLastName;
    private String secondLastName;
    private String homePhone;
    private String mobilePhone;
    private String email;
    private OffsetDateTime birthDate;
    private String hand;
    private String address;
    private MaritalStatusDto maritalStatus;
    private GenderDto gender;
    private OccupationDto occupation;
    private EpsDto eps;
    private ArlDto arl;

}
