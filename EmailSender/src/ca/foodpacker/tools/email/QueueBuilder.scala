package ca.foodpacker.tools.email
import java.sql.{Connection,DriverManager,SQLException}
import org.apache.commons.dbutils.ResultSetHandler
import java.sql.ResultSet

object QueueBuilder {
	def build:MailQueue={
	  val ret=new MailQueue();
	  //TODO: the queue will be built from the database
	  try{
	    val conn=DriverManager getConnection "jdbc:mysql://localhost/opencart?" +
	    		"user=opencart&password=ilovesun"
	    val h=new ResultSetHandler[Email](){
	      @throws(classOf [SQLException])
	      override def handle(rs:ResultSet):Email={
	        return null;
	      }
	    }
	    
	  }catch
	  {
	    case e:SQLException => e.printStackTrace();
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