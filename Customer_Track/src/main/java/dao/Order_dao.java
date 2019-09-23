package dao;



import java.util.List;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entry.Order;
import entry.Operator;

@Repository
public interface Order_dao {
	@Select("SELECT * FROM  c_order " )
	public List<Order> select1();
	@Select("select count(1) from c_order inner join c_client on c_order.clientid=c_client.id inner join c_operator on c_order.operatorid=c_operator.id ${where}")
	public Integer search(@Param(value = "where") String where);
	
	@Select("select c_order.*,c_client.name clientname,c_operator.name username from c_order inner join c_client on c_order.clientid=c_client.id inner join c_operator on c_order.operatorid=c_operator.id ${where} ${limit}")
	public List<Order> select(@Param(value = "where") String where, @Param(value = "limit") String limit);
	
	@Insert("insert into c_order(name,clientid,createdate,compdate,orderdate,startdate,enddate,operatorid,info,files,compoperatorids,operatornames,compweight,status,amount,comments) values(#{name},#{clientid},#{createdate},#{compdate},#{orderdate},#{startdate},#{enddate},#{operatorid},#{info},#{files},#{compoperatorids},#{operatornames},#{compweight},#{status},#{amount},#{comments})")
	public Integer insert(Order b);
	
	@Update("update c_order set name=#{name},clientid=#{clientid},compdate=#{compdate},orderdate=#{orderdate},startdate=#{startdate},enddate=#{enddate},operatorid=#{operatorid},info=#{info},files=#{files},compoperatorids=#{compoperatorids},operatornames=#{operatornames},compweight=#{compweight},status=#{status},amount=#{amount},comments=#{comments} where id=#{id}")
	public Integer update(Order b);
	
	@Delete("delete from c_order  where id=#{id}")
	public Integer delete(@Param("id")Integer id);
	
	@Select("select * from  c_order where id = #{id}")
	public Order selectById(@Param(value = "id")Integer id);

}
