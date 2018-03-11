import org.scalatest.{FlatSpec, Matchers}

class BerlinClockSpec extends FlatSpec with Matchers{

    def secondes(n : Int): String = n / 2 % 2 match {
        case 0 => "O"
        case 1 => "R"
    }

    def htop(heure: Int): String = heure / 5 match {
        case 0 => "OOOO"
        case 1 => "ROOO"
        case 2 => "RROO"
        case 3 => "RRRO"
        case 4 => "RRRR"
    }

    def hbot(heure: Int): String = heure % 5 match {
        case 0 => "OOOO"
        case 1 => "ROOO"
        case 2 => "RROO"
        case 3 => "RRRO"
        case 4 => "RRRR"
    }

    def berlinClock(time: String): Array[String] = {
        val timeElement = time.split(":").map(_.toInt)



        Array(secondes(timeElement(2)),
            htop(timeElement(0)),
            hbot(timeElement(0)))
    }

    it should "La lampe clignote toutes les deux secondes en commencant eteinte" in {
        assert(berlinClock("00:00:00")(0) == "O")
        assert(berlinClock("00:00:01")(0) == "O")
        assert(berlinClock("00:00:02")(0) == "R")
        assert(berlinClock("00:00:03")(0) == "R")
    }

    it should "retourne les heures top" in {
        assert(berlinClock("00:00:00")(1) == "OOOO")
        assert(berlinClock("05:00:00")(1) == "ROOO")
        assert(berlinClock("10:00:00")(1) == "RROO")
        assert(berlinClock("15:00:00")(1) == "RRRO")
        assert(berlinClock("20:00:00")(1) == "RRRR")
    }

    it should "retourne les heures bottom" in {
        assert(berlinClock("00:00:00")(2) == "OOOO")
        assert(berlinClock("01:00:00")(2) == "ROOO")
        assert(berlinClock("02:00:00")(2) == "RROO")
        assert(berlinClock("03:00:00")(2) == "RRRO")
        assert(berlinClock("04:00:00")(2) == "RRRR")
    }
}
