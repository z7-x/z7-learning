package com.example.springboot.service;

import com.example.springboot.entity.SecEmployee;

import java.util.List;

/**
 * 项目名称：data-leading-in
 * 类 名 称：EmployeeService
 * 类 描 述：TODO
 * 创建时间：2020/4/1 6:30 下午
 * 创 建 人：apple
 */

public interface EmployeeService {

    /**
     * 同步人员信息
     */
    int addEmployee( List<SecEmployee> secEmployeesList);
}
