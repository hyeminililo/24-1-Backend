package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.entity.Department;
import net.skhu.repository.DepartmentRepository;

@RestController
public class DepartmentController {
	@Autowired DepartmentRepository departmentRepository;
	
	// 서버에 데이터 조회 요청  -> URL 이름이 /departments 
	@GetMapping("departments")
	public List<Department> departments() { // 모든 Department 엔티티를 조회해 반환 (리스트로) 
		return departmentRepository.findAll();
	}
	// id 값에 대한 서버에 데이터 조회 요청 
	@GetMapping("department/{id}")
	public Department department(@PathVariable("id") int id) { //URL 경로 변수인 id를 메서드를 파라미터로 받음 
		return departmentRepository.findById(id).get(); // 주어진 id로 Department 엔티티 조회
	}
	// 서버에 데이터 등록 요청 -> 요청 본문에 있는 Department 객체를 메서드 파라미터로 받음 
	@PostMapping("department")
	public boolean insert(@RequestBody Department department) {
		departmentRepository.save(department); // 새로운 엔티티를 데베에 저장 
		return true;
	}
	@PutMapping("department")
	public boolean update(@RequestBody Department department) {
		departmentRepository.save(department);
		return true ;
	}
	@DeleteMapping("department/{id}")
	public boolean delete(@PathVariable("id") int id) {
		departmentRepository.deleteById(id);
		return true;
	}
}
