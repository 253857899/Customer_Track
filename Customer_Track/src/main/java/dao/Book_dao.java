package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entry.Book;
import entry.Type;

@Repository
public interface Book_dao {
	@Select("SELECT * FROM  book " )
	public List<Book> select();
	@Delete("delete from type where id = #{id} ")
	public void delete(int id);
	@Insert("insert into book(name,status,typeid) value(#{name},#{status},#{typeid})")
	public void insert(Book t);
	@Update("update book set name=#{name},status=#{status},typeid=#{typeid} where id=#{id}")
	public void update(Book t);
	@Select("select * from book where id = #{id}")
	public Book selectById(int id);
}
