
package top.codx.core.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TrackException extends RuntimeException {

    private static final long serialVersionUID = -5103833850956753763L;

    /**
     * 错误码
     */
    private final Integer code;

    public TrackException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}

