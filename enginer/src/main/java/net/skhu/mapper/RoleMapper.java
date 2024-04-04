package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Role;
@Mapper
public interface RoleMapper {
	@Select("SELECT * FROM role")
	List<Role> findAll();
}
