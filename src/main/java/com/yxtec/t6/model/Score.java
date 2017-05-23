package com.yxtec.t6.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * TODO 类描述
 *
 * @author : <a href="mailto:jerrielau@qq.com">刘杰</a>
 * @version : 0.0.1
 * @date : 2017-05-17 22:43
 */
@Data
@ToString
@NoArgsConstructor
public class Score implements Serializable {

    private static final long serialVersionUID = 7614293838845782729L;

    private Long id;

    @NotNull(message = "sname can't be null, please input.")
    @Length(max = 50, message = "sname's length must less 50.")
    private String sname;

    @NotNull(message = "course can't be null, please input.")
    @Length(max = 100, message = "course name's length must less 100.")
    private String course;

    @NotNull(message = "score can't be null, please input.")
    @Max(value = 100)
    @Min(value = 0)
    private float score;

}
