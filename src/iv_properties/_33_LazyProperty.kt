package iv_properties

import syntax.qualifiedThis.labelsForExtensionFunctionLiterals
import util.TODO

class LazyProperty(val initializer: () -> Int) {
    private var initialized: Boolean = false
    private var lazyValue: Int = 0
    val lazy: Int
        get() {
            if (initialized == false) {
                initialized = true
                lazyValue = initializer()
                return lazyValue
            } else
                return lazyValue
        }
}

fun todoTask33(): Nothing = TODO(
    """
        Task 33.
        Add a custom getter to make the 'lazy' val really lazy.
        It should be initialized by the invocation of 'initializer()'
        at the moment of the first access.
        You can add as many additional properties as you need.
        Do not use delegated properties!
    """,
    references = { LazyProperty({ 42 }).lazy }
)
