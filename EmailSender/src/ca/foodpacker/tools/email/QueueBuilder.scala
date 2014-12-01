package ca.foodpacker.tools.email

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException

import org.apache.commons.dbutils.QueryRunner
import org.apache.commons.dbutils.ResultSetHandler

object QueueBuilder {
	def build:MailQueue={
	  val ret=new MailQueue();
	  //TODO: the queue will be built from the database
	  var conn:Connection=null;
	  try{
	    conn=DriverManager getConnection "jdbc:mysql://localhost/opencart?" +
	    		"user=opencart&password=ilovesun"
	    val h=new ResultSetHandler[Email](){
	      @throws(classOf [SQLException])
	      override def handle(rs:ResultSet):Email={
	        if(!rs.next()){
	          return null; 
	        }
	        return new Email(
	            rs.getInt("email_id"),
	            rs.getString("to"),
	            rs.getString("from"),
	            rs.getString("cc"),
	            rs.getString("title"),
	            rs.getString("content")
	            );
	      }
	    }
	    val run=new QueryRunner();
	    val emails=run.query[Email](conn,"SELECT * FROM oc_email where status=1",h);
	    for(email <- emails)
	    {
	      
	    }
	  }catch
	  {
	    case e:SQLException => e.printStackTrace();
	  }finally
	  {
	    if(conn!=null)
	    {
	      conn.close();
	    }
	  }
	  
	  ret < new Email(1,"liy@leesoft.ca",
			  "support@foodpacker.ca",
			  "stephen.liy@gmail.com",
			  "Sample Email 1",
			  "This is an sample 1")
	  ret < new Email(2,"liy@leesoft.ca",
			  "support@foodpacker.ca",
			  "stephen.liy@gmail.com",
			  "Sample Email 2",
			  "This is an sample 2")
	  ret < new Email(3,"liy@leesoft.ca",
			  "support@foodpacker.ca",
			  "stephen.liy@gmail.com",
			  "Sample Email 3",
			  "This is an sample 3")
	  
	  return ret
	}
}