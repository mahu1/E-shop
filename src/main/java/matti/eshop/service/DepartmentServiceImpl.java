package matti.eshop.service;

import java.util.ArrayList;
import java.util.List;

import matti.eshop.dao.DepartmentDao;
import matti.eshop.model.Department;

import org.springframework.transaction.annotation.Transactional;

public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao departmentDao;
	
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	private List<DepartmentDto> toDepartmentDtos(List<Department> departments) {
		List<DepartmentDto> dtos = new ArrayList<DepartmentDto>();
		for(Department department : departments) {
			DepartmentDto dto = new DepartmentDto();
			dto.setDepartmentId(department.getDepartmentId());
			dto.setTitle(department.getTitle());
			dtos.add(dto);
		}
		return dtos;
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<DepartmentDto> getAllDepartments() {
		return toDepartmentDtos(departmentDao.getAll());
	}

}
