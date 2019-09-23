package dao;



import java.util.List;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entry.Order;
import entry.Orderdetails;
import entry.Operator;

@Repository
public interface Orderdetails_dao {
	@Select("SELECT * FROM  c_orderdetails " )
	public List<Orderdetails> select1();
	@Select("select count(1) from c_orderdetails inner join c_order on c_orderdetails.orderid=c_order.id inner join c_product on c_orderdetails.productid=c_product.id ${where}")
	public Integer search(@Param(value = "where") String where);
	
	@Select("select c_orderdetails.*,c_order.name ordername,c_product.name productname from c_orderdetails inner join c_order on c_orderdetails.orderid=c_order.id inner join c_product on c_orderdetails.productid=c_product.id ${where} ${limit}")
	public List<Orderdetails> select(@Param(value = "where") String where, @Param(value = "limit") String limit);
	
	@Insert("insert into c_orderdetails(orderid,productid,count,amount,desc,comments) values(#{orderid},#{productid},#{count},#{amount},#{desc},#{comments})")
	public Integer insert(Orderdetails b);
	
	@Update("update c_orderdetails set orderid=#{orderid},productid=#{productid},count=#{count},amount=#{amount},desc=#{desc},comments=#{comments} where id=#{id}")
	public Integer update(Orderdetails b);
	
	@Delete("delete from c_orderdetails  where id=#{id}")
	public Integer delete(@Param("id")Integer id);
	
	@Select("select * from  c_orderdetails where id = #{id}")
	public Orderdetails selectById(@Param(value = "id")Integer id);
	
	@Select("select * from  c_orderdetails where orderid = #{orderid}")
	public Orderdetails selectByOrderId(@Param(value = "orderid")Integer orderid);

}
