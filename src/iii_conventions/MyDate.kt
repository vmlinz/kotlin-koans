package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if (this.year == other.year) {
            if (this.month == this.month) {
                return this.dayOfMonth - other.dayOfMonth
            } else {
                return this.month - other.month
            }
        } else {
            return this.year - other.year
        }
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

infix operator fun MyDate.plus(timeInterval: TimeInterval): MyDate {
    return this.addTimeIntervals(timeInterval, 1)
}

infix operator fun MyDate.plus(repeatedTimeInterval: RepeatedTimeInterval): MyDate {
    return this.addTimeIntervals(repeatedTimeInterval.timeInterval, repeatedTimeInterval.times)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var current = start
            override fun hasNext(): Boolean {
                return current <= endInclusive
            }

            override fun next(): MyDate {
                val result = current
                current = current.nextDay()
                return result
            }

        }
    }
}

class RepeatedTimeInterval(val timeInterval: TimeInterval, val times: Int)

infix operator fun TimeInterval.times(times: Int): RepeatedTimeInterval {
    return RepeatedTimeInterval(this, times)
}

