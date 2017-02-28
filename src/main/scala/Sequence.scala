import scalaz._
import Scalaz._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
/**
  * Created by taishi.watanabe on 2017/02/28.
  */
class Sequence {
  val l: List[Option[Int]] = List(1.some, 2.some)
  val l2: Option[List[Int]] = l.sequenceU
  val a: Future[Option[Future[Option[Int]]]] = Future(None)
  val a2: Future[Future[Option[Int]]] = a.map(_.sequence.map(_.join))
  a >>= (_.sequence.map(_.join)): Future[Option[Int]]
  val x:Int = 1: Int
}
