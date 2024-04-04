package net.skhu.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import net.skhu.dto.Student;

@Mapper
public interface StudentMapper {
    
    // 특정 학생 정보 조회
    @Select("SELECT * FROM student WHERE id = #{id}")
    Student findOne(int id);
    
    // 모든 학생 정보 조회 (학과 이름 포함)
    @Select("""
            SELECT s.*, d.name departmentName
            FROM student s LEFT JOIN department d ON s.departmentId = d.id
            """)
    List<Student> findAll();
    
    // 학생 정보 삽입
    @Insert("""
            INSERT INTO student (studentNo, name, departmentId, phone, sex, email)
            VALUES (#{studentNo}, #{name}, #{departmentId}, #{phone}, #{sex}, #{email})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Student student);
    
    // 학생 정보 수정
    @Update("""
            UPDATE student
            SET studentNo = #{studentNo},
                name = #{name},
                departmentId = #{departmentId},
                phone = #{phone},
                sex = #{sex},
                email = #{email}
            WHERE id = #{id}
            """)
    void update(Student student);
    
    // 특정 학생 정보 삭제
    @Delete("DELETE FROM student WHERE id = #{id}")
    void delete(int id);
}
