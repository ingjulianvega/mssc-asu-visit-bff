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
public class DocumentTypeDto implements Serializable {
    static final long serialVersionUID = -6032716396348087779L;

    @Null
    private UUID id;
    private String name;
    private String abbreviation;

}

