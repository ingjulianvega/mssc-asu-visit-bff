package ingjulianvega.ximic.events;

import ingjulianvega.ximic.msscasuvisitbff.web.model.RemissionDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateRemissionEvent implements Serializable {
    static final long serialVersionUID = -470076517233916881L;

    private RemissionDto remissionDto;

}
