package ca.foodpacker.tools.email

object EmailSender {

  def main(args: Array[String]): Unit = {
    println("Dispatch the email")
    val q = QueueBuilder.build;
    while(!(q isEnd)){
      val email=q.pop
      val actor=new EmailActor(email)
      actor start;
    }
  }

}