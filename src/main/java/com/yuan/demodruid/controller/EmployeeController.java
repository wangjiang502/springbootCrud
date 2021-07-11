package com.yuan.demodruid.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.demodruid.domain.entity.Employee;
import com.yuan.demodruid.mapper.EmployeeMapper;
import com.yuan.demodruid.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wangjiang
 * @since 2021-07-11
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("/detail")
    public Object getById(Employee employee) {
        return employeeService.getById(employee.getId());
    }

    @GetMapping("list")
    public List<Employee> getEmployeeList(Employee employee) {
        LambdaQueryWrapper<Employee> queryWrapper = Wrappers
                .<Employee>lambdaQuery().select();
        LambdaQueryWrapper<Employee> employees = queryWrapper
                .eq(Employee::getId, employee.getId())
                .like(Employee::getName, employee.getName());
        return Arrays.asList(employee);
    }

    @PostMapping("/search/{pages}/{size}")
    public IPage<Employee> findByPage(@PathVariable Integer pages, @PathVariable Integer size) {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        Page<Employee> page = new Page<>(pages, size);
        IPage<Employee> iPage = employeeMapper.selectPage(page, queryWrapper);
        return iPage;
    }
}