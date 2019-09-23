package dao;

import java.util.List;



import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entry.Product;


@Repository
public interface Product_dao {
	@Select("select count(1) from c_product ${where}")
	public Integer search(@Param(value = "where") String where);
	@Select("select * from c_product ")
	public List<Product> select1();
	@Select("select * from c_product ${where} ${limit}")
	public List<Product> select(@Param(value = "where") String where, @Param(value = "limit") String limit);
	@Delete("delete from c_product where id = #{id} ")
	public void delete(@Param("id")Integer id);
	@Insert("insert into c_product(id,name,amount,info) value(#{id},#{name},#{amount},#{info})")
	public void insert(Product t);
	@Update("update c_product set id=#{id},name=#{name},amount=#{amount},info=#{info} where id=#{id}")
	public void update(Product t);
	@Select("select * from c_product where id = #{id}")
	public Product selectById(@Param("id")Integer id);
}
