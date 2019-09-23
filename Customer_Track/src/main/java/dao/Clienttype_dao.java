package dao;

import java.util.List;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entry.Clienttype;



@Repository
public interface Clienttype_dao {
	@Select("select count(1) from c_clienttype ${where}")
	public Integer search(@Param(value = "where") String where);
	@Select("select * from c_clienttype ")
	public List<Clienttype> select1();
	@Select("select * from c_clienttype ${where} ${limit}")
	public List<Clienttype> select(@Param(value = "where") String where, @Param(value = "limit") String limit);
	@Delete("delete from c_clienttype where id = #{id} ")
	public void delete(@Param("id")Integer id);
	@Insert("insert into c_clienttype(id,name) value(#{id},#{name})")
	public void insert(Clienttype t);
	@Update("update c_clienttype set id=#{id},name=#{name} where id=#{id}")
	public void update(Clienttype t);
	@Select("select * from c_clienttype where id = #{id}")
	public Clienttype selectById(@Param("id")Integer id);
}
