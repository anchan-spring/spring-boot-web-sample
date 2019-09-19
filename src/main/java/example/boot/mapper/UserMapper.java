package example.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import example.boot.entity.UserEntity;

@Mapper
public interface UserMapper {

	@Select("select * from spring_web_sample.user")
    List<UserEntity> selectAll();

	@Delete("delete from spring_web_sample.user where userId = #{userId}")
	void delete(String userId);

	@Insert("insert into spring_web_sample.user values ( #{userId},#{firstName},#{lastName} )")
	void insert(@Param("userId")String userId,@Param("firstName")String firstName,@Param("lastName")String lastName);
}
