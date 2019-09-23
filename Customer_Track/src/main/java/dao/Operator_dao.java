package dao;



import java.util.List;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entry.Operator;

@Repository
public interface Operator_dao {
	
	@Select("SELECT * FROM  c_operator  where name =#{name} and pass = #{pass}" )
	public Operator login(Operator t);
	@Select("SELECT * FROM  c_operator " )
	public List<Operator> select1();
	@Select("select count(1) from c_operator inner join c_workgroup on c_operator.groupid=c_workgroup.id ${where}")
	public Integer search(@Param(value = "where") String where);
	
	@Select("select c_operator.*,c_workgroup.name groupname from c_operator inner join c_workgroup on c_operator.groupid=c_workgroup.id ${where} ${limit}")
	public List<Operator> select(@Param(value = "where") String where, @Param(value = "limit") String limit);
	
	@Insert("insert into c_operator(name,pass,tel,groupid,power,status) values(#{name},#{pass},#{tel},#{groupid},#{power},#{status})")
	public Integer insert(Operator b);
	
	@Update("update c_operator set name=#{name},pass=#{pass},tel=#{tel},groupid=#{groupid},power=#{power},status=#{status} where id=#{id}")
	public Integer update(Operator b);
	
	@Delete("delete from c_operator  where id=#{id}")
	public Integer delete(@Param("id")Integer id);
	
	@Select("select * from  c_operator where id = #{id}")
	public Operator selectById(@Param(value = "id")Integer id);

}
