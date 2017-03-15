package tr.xip.timetable.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View

/**
 * Convenience function for getting [LayoutInflater]
 */
fun Context.getLayoutInflater(): LayoutInflater {
    return getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
}

/**
 * Even more convenience.
 *
 * @see getLayoutInflater()
 */
fun View.getLayoutInflater(): LayoutInflater {
    return context.getLayoutInflater()
}