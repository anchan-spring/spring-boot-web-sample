package example.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import example.boot.entity.UserEntity;

@Mapper
public interface UserMapper {

	@Select("select * from spring_web_sample.user")
    List<UserEntity> selectAll();
}
