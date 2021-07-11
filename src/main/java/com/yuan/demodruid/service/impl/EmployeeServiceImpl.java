package com.yuan.demodruid.service.impl;

import com.yuan.demodruid.domain.entity.Employee;
import com.yuan.demodruid.mapper.EmployeeMapper;
import com.yuan.demodruid.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangjiang
 * @since 2021-07-11
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
