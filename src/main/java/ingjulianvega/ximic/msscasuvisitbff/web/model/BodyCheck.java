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
public class BodyCheck implements Serializable {

    static final long serialVersionUID = -449565990116357619L;

    private UUID visitId;
    private UUID bodyPartId;
    private String observations;

}
