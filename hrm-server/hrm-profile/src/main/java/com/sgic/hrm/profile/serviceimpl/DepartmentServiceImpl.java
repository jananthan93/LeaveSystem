package com.sgic.hrm.profile.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.Department;
import com.sgic.hrm.commons.repository.DepartmentRepository;
import com.sgic.hrm.profile.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
  @Autowired
  private DepartmentRepository departmentRepo;

  @Override
  public boolean addDepartment(Department department) {
    departmentRepo.save(department);
    return true;
  }

  @Override
  public List<Department> getDepartment() {

    return departmentRepo.findAll();
  }

  @Override
  public Department findByDepartmentId(Integer id) {
    return departmentRepo.findDepartmentById(id);

  }

  @Override
  public boolean editDepartment(Department department, Integer id) {
    if (departmentRepo.getOne(id) != null) {
      department.setId(id);
      departmentRepo.save(department);
      return true;
    }
    return false;
  }

  @Override
  public boolean deleteDepartment(Integer id) {
    if (departmentRepo.getOne(id) != null) {
      departmentRepo.deleteById(id);
      return true;
    }
    return false;
  }



}
