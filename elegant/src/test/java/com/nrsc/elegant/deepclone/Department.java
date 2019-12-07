package com.nrsc.elegant.deepclone;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/***
 * @author : Sun Chuan
 * @date : 2019/12/4 17:50
 * Description: 
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Department {
    private String departmentCode;

    private String departmentName;

    public Department(String departmentCode, String departmentName) {
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
    }
}
