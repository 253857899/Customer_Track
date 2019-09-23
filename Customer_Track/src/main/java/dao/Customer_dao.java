package dao;

import java.util.List;




import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entry.Customer;
import entry.Group;

@Repository
public interface Customer_dao {

	@Select("select id,name from c_client ")
	public List<Customer> select1();
	
	@Select("select count(1) from c_client inner join c_clienttype on c_client.clienttypeid=c_clienttype.id inner join c_src on c_client.srcid=c_src.id inner join c_operator on c_client.createoperatorid=c_operator.id ${where}")
	public Integer search(@Param(value = "where") String where);
	
	@Select("SELECT c_client.*,c_clienttype.name typename,c_src.name srcname,c_operator.name createoperatorname from c_client inner join c_clienttype on c_client.clienttypeid=c_clienttype.id inner join c_src on c_client.srcid=c_src.id inner join c_operator on c_client.createoperatorid=c_operator.id ${where} ${limit}")
	public List<Customer> select(@Param(value = "where") String where, @Param(value = "limit") String limit);
	@Select("SELECT c_client.*, c_operator.NAME operators FROM c_client INNER JOIN c_operator ON c_client.operatorids = c_operator.id ")
	public List<Customer> selects();
	@Insert("insert into c_client(name,sex,tel,qq,email,infos,linkstatus,clientstatus,purposestatus,assessstatus,execstatus,status,clienttypeid,operatorids,operatornames,createoperatorid,createdate,srcid,count,comments) values(#{name},#{sex},#{tel},#{qq},#{email},#{infos},#{linkstatus},#{clientstatus},#{purposestatus},#{assessstatus},#{execstatus},#{status},#{clienttypeid},#{operatorids},#{operatornames},#{createoperatorid},#{createdate},#{srcid},#{count},#{comments})")
	public Integer insert(Customer b);
	
	@Update("update c_client set name=#{name},sex=#{sex},tel=#{tel},qq=#{qq},email=#{email},infos=#{infos},linkstatus=#{linkstatus},clientstatus=#{clientstatus},purposestatus=#{purposestatus},assessstatus=#{assessstatus},execstatus=#{execstatus},status=#{status},clienttypeid=#{clienttypeid},operatorids=#{operatorids},operatornames=#{operatornames},createoperatorid=#{createoperatorid},srcid=#{srcid},count=#{count},comments=#{comments} where id=#{id}")
	public Integer update(Customer b);
	
	@Delete("delete from c_client  where id=#{id}")
	public Integer delete(@Param("id")Integer id);
	
	@Select("select * from  c_client where id = #{id}")
	public Customer selectById(@Param(value = "id")Integer id);
	
	@Update("update c_client set operatorids=#{operatorids},operatornames = #{operatornames} where id=#{id}")
	public Integer update1(Customer b);
	@Update("update c_client set operatorids=null,operatornames = '' where id=#{id}")
	public Integer update2(Customer b);
}
