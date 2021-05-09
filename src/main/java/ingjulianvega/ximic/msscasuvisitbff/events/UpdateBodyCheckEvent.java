package ingjulianvega.ximic.msscasuvisitbff.events;

import ingjulianvega.ximic.msscasuvisitbff.web.model.BodyCheckDto;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateBodyCheckEvent implements Serializable {
    static final long serialVersionUID = 4180110919321178607L;

    private BodyCheckDto bodyCheckDto;

}
