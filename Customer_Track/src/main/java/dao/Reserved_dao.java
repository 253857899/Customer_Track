package dao;



import java.util.List;



import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entry.Reserved;
import entry.Group;


@Repository
public interface Reserved_dao {

	@Select("select count(1) from c_reserved INNER JOIN c_revisit ON c_reserved.revisitid = c_revisit.id INNER JOIN c_client ON c_reserved.clientid = c_client.id INNER JOIN c_operator ON c_reserved.operatorid = c_operator.id INNER JOIN c_operator o1 ON c_reserved.execoperatorid = o1.id ${where}")
	public Integer search(@Param(value = "where") String where);
	@Select("select * from c_reserved ")
	public List<Reserved> select1();
	@Select("select c_reserved.*,c_revisit.name revisitname,c_client.name clientname,c_operator.name username,o1.name execoperatorname from c_reserved INNER JOIN c_revisit ON c_reserved.revisitid = c_revisit.id INNER JOIN c_client ON c_reserved.clientid = c_client.id INNER JOIN c_operator ON c_reserved.operatorid = c_operator.id INNER JOIN c_operator o1 ON c_reserved.execoperatorid = o1.id ${where} ${limit}")
	public List<Reserved> select(@Param(value = "where") String where, @Param(value = "limit") String limit);
	
	@Insert("insert into c_reserved(id,revisitid,clientid,createdate,operatorid,date,execoperatorid,type,status,execstatus,result) values(#{id},#{revisitid},#{clientid},#{createdate},#{operatorid},#{date},#{execoperatorid},#{type},#{status},#{execstatus},#{result})")
	public Integer insert(Reserved b);

	@Update("update c_reserved set id=#{id},revisitid=#{revisitid},clientid=#{clientid},operatorid=#{operatorid},date=#{date},execoperatorid=#{execoperatorid},type=#{type},status=#{status},execstatus=#{execstatus},result=#{result} where id=#{id}")
	public Integer update(Reserved b);
	
	@Delete("delete from c_reserved  where id=#{id}")
	public Integer delete(@Param("id")Integer id);
	
	@Select("select * from  c_reserved where id = #{id}")
	public Reserved selectById(@Param(value = "id")Integer id);

}
