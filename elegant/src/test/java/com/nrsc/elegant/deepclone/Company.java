package com.nrsc.elegant.deepclone;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/***
 * @author : Sun Chuan
 * @date : 2019/12/4 17:03
 * Description: 
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Company {

    private String companyCode;
    private String companyName;

    private Department department;

    public Company(String companyCode, String companyName) {
        this.companyCode = companyCode;
        this.companyName = companyName;
    }
}
