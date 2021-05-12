package ingjulianvega.ximic.events;

import ingjulianvega.ximic.msscasuvisitbff.web.model.SystemCheckDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateSystemCheckEvent implements Serializable {
    static final long serialVersionUID = 2946964379840635654L;

    private SystemCheckDto systemCheckDto;

}
