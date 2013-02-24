class Parser {
  val dispatcher = collection.immutable.HashMap("add" -> add _)

  def parse(s: String) {
    val array = s.split(" ")
    if (array(0) == "") {
      throw new Exception("Invalid instruction")
    }
    val handler = dispatcher.get(array(0))
    handler match {
      case None => throw new Exception("Unknown instruction")
      case Some(f) => f(array.drop(1))
    }
  }

  def add(args: Array[String]) {
    println(args mkString " ")
  }
}


object Interpreter {
  def main(args: Array[String]) {
    val parser = new Parser
    while (true) {
      val ln = Console.readLine()
      parser.parse(ln)
    }
  }
}
