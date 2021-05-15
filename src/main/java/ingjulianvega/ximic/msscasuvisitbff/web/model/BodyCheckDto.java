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
public class BodyCheckDto implements Serializable {

    static final long serialVersionUID = -4904385362557689427L;

    private UUID id;
    private UUID visitId;
    private UUID bodyPartId;
    private String observations;

}
