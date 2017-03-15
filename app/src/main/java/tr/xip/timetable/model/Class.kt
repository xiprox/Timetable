package tr.xip.timetable.model

import java.io.Serializable

/**
 * A class period in a day
 */
class Class : Serializable {
    val id: Int? = null
    val name: String? = null
    val prof: String? = null
    val place: String? = null
    val day: Int? = null
    val startTime: Int? = null
    val endTime: Int? = null

    val length: Int
        get() = (endTime ?: 0) - (startTime ?: 0)
}