package vi_generics

import util.TODO
import java.util.*

fun task41(): Nothing = TODO(
    """
        Task41.
        Add a 'partitionTo' function that splits a collection into two collections according to a predicate.
        Uncomment the commented invocations of 'partitionTo' below and make them compile.

        There is a 'partition()' function in the standard library that always returns two newly created lists.
        You should write a function that splits the collection into two collections given as arguments.
        The signature of the 'toCollection()' function from the standard library may help you.
    """,
        references = { l: List<Int> ->
            l.partition { it > 0 }
            l.toCollection(HashSet<Int>())
        }
)

fun List<String>.partitionWordsAndLines(): Pair<List<String>, List<String>> {
    return partitionTo(ArrayList<String>(), ArrayList()) { s -> !s.contains(" ") }
}


fun Set<Char>.partitionLettersAndOtherSymbols(): Pair<Set<Char>, Set<Char>> {
    return partitionTo(HashSet<Char>(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z'}
}

fun <T> List<T>.partitionTo(collection1: List<T>, collection2: List<T>, predicate: (c: T) -> Boolean): Pair<List<T>, List<T>> {
    return this.partition { predicate(it)}
}

fun <T> Set<T>.partitionTo(collection1: Set<T>, collection2: Set<T>, predicate: (c: T) -> Boolean): Pair<Set<T>, Set<T>> {
    val pair = this.toList().partition { predicate(it) }
    return Pair(pair.first.toHashSet(), pair.second.toHashSet())
}
