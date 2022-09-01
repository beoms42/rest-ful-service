package spectra.yicho.restfulservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
// @JsonIgnoreProperties(value = {"password"})
@JsonFilter("UserInfo")
@NoArgsConstructor
@ApiModel(description = "사용사 상세 저옵를 위한 도메인 객체")
public class User {
    private Integer id;

    // Validation annotation > 유효성 검사
    @Size(min=2)
    @ApiModelProperty(notes = "사용자 이름을 입력해 주세요.")
    private String name;
    @Past
    @ApiModelProperty(notes = "사용자 등록일을 입력해 주세요.")
    private Date joinDate;
    @ApiModelProperty(notes = "패스워드을 입력해 주세요.")
    private String password;
    @ApiModelProperty(notes = "사용자 주민번호을 입력해 주세요.")
    private String ssn;

}
