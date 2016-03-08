package iv_properties

import util.TODO
import util.doc34
import kotlin.reflect.KProperty

class LazyPropertyUsingDelegates(val initializer: () -> Int) {
    val lazyValue: Int by Delegate(initializer)
}

class Delegate {
    private val lazyInitializer: () -> Int
    private var lazyValue: Int = 0
    private var initialized: Boolean = false

    constructor(initializer: () -> Int){
        this.lazyInitializer = initializer
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        if (initialized) {
            return lazyValue
        } else {
            lazyValue = lazyInitializer()
            initialized = true
            return lazyValue
        }
    }
}

fun todoTask34(): Lazy<Int> = TODO(
    """
        Task 34.
        Read about delegated properties and make the property lazy by using delegates.
    """,
    documentation = doc34()
)
