package dao;



import java.util.List;



import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entry.Reserved;
import entry.Revisit;


@Repository
public interface Revisit_dao {

	@Select("select count(1) from c_revisit inner join c_client on c_revisit.clientid=c_client.id ${where}")
	public Integer search(@Param(value = "where") String where);
	@Select("select * from c_revisit ")
	public List<Revisit> select1();
	@Select("select c_revisit.*,c_client.name clientname from c_revisit inner join c_client on c_revisit.clientid=c_client.id ${where} ${limit}")
	public List<Revisit> select(@Param(value = "where") String where, @Param(value = "limit") String limit);
	
	@Insert("insert into c_revisit(id,name,clientid,linkstatus,clientstatus,purposestatus,assessstatus,askinfo,followinfo,probleminfo,status,comments) values(#{id},#{name},#{clientid},#{linkstatus},#{clientstatus},#{purposestatus},#{assessstatus},#{askinfo},#{followinfo},#{probleminfo},#{status},#{comments})")
	public Integer insert(Revisit b);
	
	@Update("update c_revisit set id=#{id},name=#{name},clientid=#{clientid},linkstatus=#{linkstatus},clientstatus=#{clientstatus},purposestatus=#{purposestatus},assessstatus=#{assessstatus},askinfo=#{askinfo},followinfo=#{followinfo},probleminfo=#{probleminfo},status=#{status},comments=#{comments} where id=#{id}")
	public Integer update(Revisit b);
	
	@Delete("delete from c_revisit  where id=#{id}")
	public Integer delete(@Param("id")Integer id);
	
	@Select("select * from  c_revisit where id = #{id}")
	public Revisit selectById(@Param(value = "id")Integer id);

}
