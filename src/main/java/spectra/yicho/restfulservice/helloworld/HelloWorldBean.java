package spectra.yicho.restfulservice.helloworld;

//lombok

import lombok.AllArgsConstructor;
import lombok.Data;

//모든 인자를 가지고잇는 구조체
// 생성자로 this.message = message를 해주는것을 생략해주는 annotation
@Data
@AllArgsConstructor
public class HelloWorldBean {
    private String message;
    private String pocket;

}
