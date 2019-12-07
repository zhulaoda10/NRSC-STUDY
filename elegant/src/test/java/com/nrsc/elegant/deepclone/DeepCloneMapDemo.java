package com.nrsc.elegant.deepclone;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.HashMap;
import java.util.Map;

/***
 *  @author : Sun Chuan
 *  @date : 2019/12/7 21:23
 *  Description：
 */
public class DeepCloneMapDemo {

    /****
     * value为基本数据类型、String时
     */
    @Test
    public void MapDemo1() {

        Map<String, String> map = new HashMap<>();
        System.err.println("map加入内容前=" + System.identityHashCode(map));
        map.put("热火", "wade");
        System.err.println("map加入内容后=" + System.identityHashCode(map));

        Map<String, String> copyMap1 = new HashMap<>();
        System.out.println("copyMap1加入内容前=" + System.identityHashCode(copyMap1));
        copyMap1 = map;
        System.out.println("copyMap1加入内容后=" + System.identityHashCode(copyMap1));

        Map<String, String> copyMap2 = new HashMap<>();
        System.err.println("copyMap2加入内容前=" + System.identityHashCode(copyMap2));
        copyMap2.putAll(map);
        System.err.println("copyMap2加入内容后=" + System.identityHashCode(copyMap2));


        map.put("热火", "james");
        System.out.println("直接修改的====" + System.identityHashCode(map) + "===" + map);
        System.out.println("不想修改的====" + System.identityHashCode(copyMap1) + copyMap1);
        System.out.println("不想修改的====" + System.identityHashCode(copyMap2) + copyMap2);
    }

    /****
     * value为对象时
     */
    @Test
    public void MapDemo2() {
        Company company1 = new Company("heat", "wade");
        Map<String, Company> map = new HashMap<>();

        System.err.println("map加入内容前=" + System.identityHashCode(map));
        map.put("热火", company1);
        System.err.println("map加入内容后=" + System.identityHashCode(map));

        Map<String, Company> copyMap1 = new HashMap<>();
        System.out.println("copyMap1加入内容前=" + System.identityHashCode(copyMap1));
        copyMap1 = map;
        System.out.println("copyMap1加入内容后=" + System.identityHashCode(copyMap1));

        Map<String, Company> copyMap2 = new HashMap<>();
        System.err.println("copyMap2加入内容前=" + System.identityHashCode(copyMap2));
        copyMap2.putAll(map);
        System.err.println("copyMap2加入内容后=" + System.identityHashCode(copyMap2));

        company1.setCompanyCode("1001");
        System.out.println("直接修改的====" + System.identityHashCode(map) + map);
        System.out.println("不想修改的====" + System.identityHashCode(copyMap1) + copyMap1);
        System.out.println("不想修改的====" + System.identityHashCode(copyMap2) + copyMap2);
    }

    @Test
    public void MapDemo2_1() {
        Company company1 = new Company("heat", "wade");
        Map<String, Company> map = new HashMap<>();

        System.out.println("map加入内容前=" + System.identityHashCode(map));
        map.put("热火", company1);
        System.out.println("map加入内容后=" + System.identityHashCode(map));


        Map<String, Company> copyMap2 = new HashMap<>();
        System.err.println("copyMap2加入内容前=" + System.identityHashCode(copyMap2));
        //(1)从map中取出company1
        Company company1_1 = map.get("热火");
        //(2)新建一个Company对象 --- JVM会在堆中为其分配一个新的地址
        Company deepCopyCompany = new Company();
        //(3)将从map中取出的Company对像的属性复制给新的Company对象
        BeanUtils.copyProperties(company1_1, deepCopyCompany);
        //(4)将新的对象给copyMap2 ---> 完成深拷贝的过程
        copyMap2.put("热火", deepCopyCompany);
        System.err.println("copyMap2加入内容后=" + System.identityHashCode(copyMap2));

        //修改company1--->可以发现map中Company对象的值会变化，但copyMap2的不会
        company1.setCompanyCode("1001");
        System.out.println("直接修改的====" + System.identityHashCode(map) + map);
        System.out.println("不想修改的====" + System.identityHashCode(copyMap2) + copyMap2);
    }


    /***
     * value为基本数据类型的包装类型时
     */
    @Test
    public void MapDemo3() {

        Map<String, Integer> map = new HashMap<>();
        System.err.println("map加入内容前=" + System.identityHashCode(map));
        map.put("热火", 1);
        System.err.println("map加入内容后=" + System.identityHashCode(map));

        Map<String, Integer> copyMap1 = new HashMap<>();
        System.out.println("copyMap1加入内容前=" + System.identityHashCode(copyMap1));
        copyMap1 = map;
        System.out.println("copyMap1加入内容后=" + System.identityHashCode(copyMap1));

        Map<String, Integer> copyMap2 = new HashMap<>();
        System.err.println("copyMap2加入内容前=" + System.identityHashCode(copyMap2));
        copyMap2.putAll(map);
        System.err.println("copyMap2加入内容后=" + System.identityHashCode(copyMap2));


        map.put("热火", 222);
        System.out.println("直接修改的====" + System.identityHashCode(map) + "===" + map);
        System.out.println("不想修改的====" + System.identityHashCode(copyMap1) + copyMap1);
        System.out.println("不想修改的====" + System.identityHashCode(copyMap2) + copyMap2);
    }

}
