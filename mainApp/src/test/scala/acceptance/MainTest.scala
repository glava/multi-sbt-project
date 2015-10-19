package acceptance

import common.utils.TestUtil
import org.scalatest._

class MainTest extends FlatSpec with Matchers {

  "A MainTest" should "be able to load test classes from common project" in {
    TestUtil.doesSomeUtilStuff should be ("do")
  }
}