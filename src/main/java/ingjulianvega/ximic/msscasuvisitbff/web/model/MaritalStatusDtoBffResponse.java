package ingjulianvega.ximic.msscasuvisitbff.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaritalStatusDtoBffResponse implements Serializable {
    static final long serialVersionUID = 1520803124561765781L;

    @Null
    private UUID id;
    private String name;

}

