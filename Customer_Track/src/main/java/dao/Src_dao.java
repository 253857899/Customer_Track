package dao;

import java.util.List;



import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entry.Src;



@Repository
public interface Src_dao {
	@Select("select count(1) from c_src ${where}")
	public Integer search(@Param(value = "where") String where);
	@Select("select * from c_src ")
	public List<Src> select1();
	@Select("select * from c_src ${where} ${limit}")
	public List<Src> select(@Param(value = "where") String where, @Param(value = "limit") String limit);
	@Delete("delete from c_src where id = #{id} ")
	public void delete(@Param("id")Integer id);
	@Insert("insert into c_src(id,name) value(#{id},#{name})")
	public void insert(Src t);
	@Update("update c_src set id=#{id},name=#{name} where id=#{id}")
	public void update(Src t);
	@Select("select * from c_src where id = #{id}")
	public Src selectById(@Param("id")Integer id);
}
