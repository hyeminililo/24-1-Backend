package net.skhu.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import net.skhu.dto.Department;

@Mapper
public interface DepartmentMapper {
    
    // 모든 학과 정보 조회
    @Select("SELECT * FROM department")
    List<Department> findAll();
}
