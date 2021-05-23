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
public class PatientDto implements Serializable {

    static final long serialVersionUID = 5138169891318784050L;

    private UUID id;
    private UUID documentTypeId;
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
    private UUID maritalStatusId;
    private UUID genderId;
    private UUID occupationId;
    private UUID epsId;
    private UUID arlId;

}
