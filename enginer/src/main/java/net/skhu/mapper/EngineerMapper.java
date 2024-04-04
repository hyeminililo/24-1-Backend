package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.Engineer;

@Mapper
public interface EngineerMapper {
	@Select("SELECT * FROM engineer WHERE id = #{id}")
	Engineer findOne(int id);

	@Select("""
			SELECT e.*, r.title role
			FROM engineer e LEFT JOIN role r ON e.roleId = r.id
			""")
	List<Engineer> findAll();

	@Insert("""
			INSERT engineer(engineerNo, name, roleId, phone, sex, email)
			VALUES (#{engineerNo}, #{name}, #{roleId}, #{phone}, #{sex}, #{email})""")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void insert(Engineer engineer);

	@Update("""
			UPDATE engineer SET
			engineerNo = #{engineerNo},
			name = #{name},
			roleId = #{roleId},
			phone = #{phone},
			sex = #{sex},
			email = #{email}
			WHERE id = #{id} """)
	void update(Engineer engineer);

	@Delete("DELETE FROM engineer WHERE id =#{id}")
	void delete(int id);
}
