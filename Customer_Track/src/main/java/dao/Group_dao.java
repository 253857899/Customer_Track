package dao;

import java.util.List;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entry.Group;
import entry.Operator;


@Repository
public interface Group_dao {
	@Select("select count(1) from c_workgroup ${where}")
	public Integer search(@Param(value = "where") String where);
	@Select("select * from c_workgroup ")
	public List<Group> select1();
	@Select("select * from c_workgroup ${where} ${limit}")
	public List<Group> select(@Param(value = "where") String where, @Param(value = "limit") String limit);
	@Delete("delete from crm_department where id = #{id} ")
	public void delete(@Param("id")Integer id);
	@Insert("insert into c_workgroup(id,name) value(#{id},#{name})")
	public void insert(Group t);
	@Update("update c_workgroup set id=#{id},name=#{name} where id=#{id}")
	public void update(Group t);
	@Select("select * from c_workgroup where id = #{id}")
	public Group selectById(@Param("id")Integer id);
}
