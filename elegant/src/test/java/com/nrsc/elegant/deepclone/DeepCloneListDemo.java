package com.nrsc.elegant.deepclone;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/***
 * @author : Sun Chuan
 * @date : 2019/12/4 10:24
 * Description: 
 */
public class DeepCloneListDemo {

    /***
     * 浅拷贝
     */
    @Test
    public void shallowCopyListDemo() {
        Company company1 = new Company("heat", "wade");
        Department department1 = new Department("2000", "开发部");
        company1.setDepartment(department1);

        Company company2 = new Company("heat", "james");
        Department department2 = new Department("3000", "技术部");
        company2.setDepartment(department2);

        System.out.println("company1===" + System.identityHashCode(company1));
        System.out.println("company2===" + System.identityHashCode(company2));

        List<Company> companyList = new ArrayList<>();
        System.err.println("companyList前==" + companyList.hashCode());
        companyList.add(company1);
        companyList.add(company2);
        System.err.println("companyList后==" + companyList.hashCode());
        //浅拷贝1
        List<Company> copyCompanyList1 = new ArrayList<>();
        System.err.println("copyCompanyList1前==" + System.identityHashCode(copyCompanyList1));
        copyCompanyList1 = companyList;
        System.err.println("copyCompanyList1后==" + System.identityHashCode(copyCompanyList1));
        //浅拷贝2
        List<Company> copyCompanyList2 = new ArrayList<>();
        System.err.println("copyCompanyList2前==" + System.identityHashCode(copyCompanyList2));
        copyCompanyList2.add(companyList.get(0));
        copyCompanyList2.add(companyList.get(1));
        System.err.println("copyCompanyList2后==" + System.identityHashCode(copyCompanyList2));

        //新建list-1
        List<Company> copyCompanyList3 = new ArrayList<>();
        copyCompanyList3.add(company1);
        copyCompanyList3.add(company2);
        System.err.println("copyCompanyList3后==" + System.identityHashCode(copyCompanyList3));

        //新建list-2
        List<Company> copyCompanyList3_1 = new ArrayList<>();
        copyCompanyList3_1.add(company2);
        copyCompanyList3_1.add(company1);
        System.err.println("copyCompanyList3_1后==" + System.identityHashCode(copyCompanyList3_1));

        //新建list-3
        List<Company> copyCompanyList4 = new ArrayList<>();
        copyCompanyList4.add(company1);
        System.err.println("copyCompanyList4后==" + System.identityHashCode(copyCompanyList4));


        System.out.println("===========浅拷贝===============");
        companyList.get(0).setCompanyCode("1002");
        companyList.get(0).getDepartment().setDepartmentName("技术部");
        System.err.println("直接修改的====" + companyList);
        System.err.println("不想修改的1====" + copyCompanyList1);
        System.err.println("不想修改的2====" + copyCompanyList2);
        System.err.println("不想修改的3====" + copyCompanyList3);
        System.err.println("不想修改的3_1====" + copyCompanyList3_1);
        System.err.println("不想修改的4====" + copyCompanyList4);
    }


    /***
     * Company深拷贝,Department浅拷贝
     */
    @Test
    public void companyDeepCopyListDemo() {
        Company company = new Company();
        company.setCompanyCode("1001");
        company.setCompanyName("热火");
        Department department = new Department();
        department.setDepartmentCode("2000");
        department.setDepartmentName("开发部");
        company.setDepartment(department);

        List<Company> companyList = new ArrayList<>();
        companyList.add(company);

        List<Company> copyCompanyList3 = new ArrayList<>();
        //(1)新建对象
        Company copyCompany = new Company();
        //(2)将原有List中对象的属性值copy到新对象
        /***
         * 特别注意:这里一定要用org.springframework.beans.BeanUtils
         *         不要用org.apache.commons.BeanUtils
         *         曾经我在项目里用过apache的,后来数据量上来之后,那个接口的响应时间骤升::>_<::
         */

        BeanUtils.copyProperties(companyList.get(0), copyCompany);
        //(3)将新对象加入到copyCompanyList3完成对象拷贝
        copyCompanyList3.add(copyCompany);

        //测试
        System.out.println("===========深拷贝===============");
        companyList.get(0).setCompanyCode("1002");
        companyList.get(0).getDepartment().setDepartmentCode("2001");
        System.err.println("直接修改的====" + companyList);
        System.err.println("不想修改的====" + copyCompanyList3);

    }

    /***
     * Company深拷贝,Department深拷贝
     */
    @Test
    public void companyAndDepartmentDeepCopyListDemo() {
        Company company = new Company();
        company.setCompanyCode("1001");
        company.setCompanyName("热火");
        Department department = new Department();
        department.setDepartmentCode("2000");
        department.setDepartmentName("开发部");
        company.setDepartment(department);

        List<Company> companyList = new ArrayList<>();
        companyList.add(company);

        List<Company> copyCompanyList3 = new ArrayList<>();
        //(1)新建Company对象
        Company copyCompany = new Company();
        //(2)将原有List中对象的属性值copy到新对象
        /***
         * 特别注意:这里一定要用org.springframework.beans.BeanUtils
         *         不要用org.apache.commons.BeanUtils
         *         曾经我在项目里用过apache的,后来数据量上来之后,那个接口的响应时间骤升::>_<::
         */
        BeanUtils.copyProperties(companyList.get(0), copyCompany);
        //(3) 新建Department对象并拷贝
        Department copyDepartment = new Department();
        BeanUtils.copyProperties(companyList.get(0).getDepartment(), copyDepartment);
        copyCompany.setDepartment(copyDepartment);

        //(4)将新对象加入到copyCompanyList3完成对象拷贝
        copyCompanyList3.add(copyCompany);

        //测试
        System.out.println("===========深拷贝===============");
        companyList.get(0).setCompanyCode("1002");
        companyList.get(0).getDepartment().setDepartmentCode("2001");
        System.err.println("直接修改的====" + companyList);
        System.err.println("不想修改的====" + copyCompanyList3);
    }
}
