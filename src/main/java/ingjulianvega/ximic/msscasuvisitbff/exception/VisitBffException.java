package ingjulianvega.ximic.msscasuvisitbff.exception;

import lombok.Getter;

@Getter
public class VisitBffException extends RuntimeException {

    private final String code;

    public VisitBffException(final String code, final String message) {
        super(message);
        this.code = code;
    }
}

