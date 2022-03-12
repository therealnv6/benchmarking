import io.github.devrawr.benchmarking.Benchmarking
import org.junit.jupiter.api.Test

class SimpleBenchmarkTest
{
    @Test
    fun createList()
    {
        val result = Benchmarking.benchmark(100) {
            val list = mutableListOf<Pair<Int, String>>()

            for (i in 0..100)
            {
                list.add(Pair(i, "hi${i}"))
            }

            for (i in 0..100)
            {
                list.removeIf {
                    it.first == i
                }
            }
        }

        println(result)
    }
}