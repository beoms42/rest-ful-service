package spectra.yicho.restfulservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    // 예외처리를 위해 사용되는 자바객체

    private Date timestamp;
    private String message;
    private String details;


}
