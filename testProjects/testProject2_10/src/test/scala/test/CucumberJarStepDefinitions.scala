package test

import cucumber.api.scala.{ScalaDsl, EN}
import org.scalatest.matchers.ShouldMatchers
import templemore.sbt.cucumber.RunCucumber
import cucumber.api.DataTable
import scala.collection.JavaConversions._

class CucumberJarStepDefinitions extends ScalaDsl with EN with ShouldMatchers {

  private var givenCalled = false
  private var whenCalled = false

  var calorieCount = 0.0

  Given("""^an SBT project$""") { () =>
    givenCalled = true
  }

  When("""^the cucumber task is called$""") { () =>
    whenCalled = true
  }

  Then("""^Cucumber is executed against the features and step definitions$""") { () =>
    givenCalled should be (true)
    whenCalled should be (true)
  }

  Given("""^I have the following foods :$"""){ (table:DataTable) =>
    calorieCount = table.asMaps().map(_.get("CALORIES")).map(_.toDouble).fold(0.0)(_+_)
  }

  And("""calories total is "(.*)"""") { (calories:Double) =>
    calories should be (calorieCount)
  }
}

class CucumberSuite extends RunCucumber
