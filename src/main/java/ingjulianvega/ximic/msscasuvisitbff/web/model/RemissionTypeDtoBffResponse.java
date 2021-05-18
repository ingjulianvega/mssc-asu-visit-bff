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
public class RemissionTypeDtoBffResponse implements Serializable {

    static final long serialVersionUID = -6318142953858305151L;

    private UUID id;
    private String name;

}
