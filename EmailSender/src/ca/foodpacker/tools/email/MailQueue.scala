package ca.foodpacker.tools.email

import scala.collection.mutable.Queue;

class MailQueue {
	val queue=new Queue[Email];
	def <(email:Email)={
	  queue += email
	}
	def pop:Email={
	  return queue.dequeue
	}
	def isEnd:Boolean={
	  return queue.length == 0;
	}
}