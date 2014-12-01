package ca.foodpacker.tools.email

class EmailActor(email:Email) extends Thread{
	override def run():Unit={
	  println("Send email to " + email.to + "with content of "+email.content);
	}
}