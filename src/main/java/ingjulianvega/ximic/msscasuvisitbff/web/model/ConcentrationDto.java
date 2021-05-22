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
public class ConcentrationDto implements Serializable {

    static final long serialVersionUID = 6848868928073400319L;

    private UUID id;
    private String name;
    private String abbreviation;

}
