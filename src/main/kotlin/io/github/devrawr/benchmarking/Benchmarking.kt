package io.github.devrawr.benchmarking

import java.time.Instant
import java.time.temporal.ChronoField

object Benchmarking
{
    fun benchmark(
        samples: Int = 1,
        unit: ChronoField = ChronoField.MILLI_OF_SECOND,
        section: String? = null,
        action: (Int) -> Unit
    ): BenchmarkResult
    {
        val begin = this.getCurrentTime(unit)

        repeat(
            times = samples,
            action = action
        )

        return BenchmarkResult(
            globalTime = this.getCurrentTime(unit) - begin,
            samples = samples.toLong(),
            unit = unit,
            section = section
        )
    }

    private fun getCurrentTime(field: ChronoField): Long
    {
        return Instant
            .now()
            .getLong(field)
    }
}