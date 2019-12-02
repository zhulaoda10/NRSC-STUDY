package com.nrsc.elegant.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author : Sun Chuan
 * @date : 2019/10/20 10:02
 * Description：
 */
@Data
@NoArgsConstructor
@ToString
public class UserInfo {
    private Long id;

    //@NotNull(message = "name不能为null")
    @NotNull(message = "name不能为空")
    private String name;

    @Min(value = 18, message = "age应大于18")
    private Integer age;

    private String sex;

    public UserInfo(@NotNull(message = "name不能为空") String name,
                    @Min(value = 18, message = "age应大于18") Integer age,
                    String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
