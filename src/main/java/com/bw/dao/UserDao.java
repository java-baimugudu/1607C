package com.bw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bw.pojo.User;

public interface UserDao {
	
	@Select("select * from user where name=#{name} and pwd=#{pwd}")
	User login(User user);
	/*@Select("select * from user")*/
	List<User> list(User user);
	@Insert("insert into user set name=#{name},pwd=#{pwd},sex=#{sex}")
	void add(User user);
	@Delete("delete from user where id=#{id}")
	void del(int id);
	@Select("select * from user where id=#{id}")
	User huixian(int id);
	
	@Update("update user set name=#{name},pwd=#{pwd},sex=#{sex} where id=#{id}")
	void update(User id);
	
	long count();
	


}
