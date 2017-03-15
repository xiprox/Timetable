package tr.xip.timetable

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import tr.xip.timetable.model.Class

class DaysPagerAdapter(val timetable: ArrayList<Class>, fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment = DayFragment.new(position + 1, timetable)

    override fun getCount(): Int = 5

    /**
     * I hardcoded day strings since this is a personal app that won't be shared or translated.
     * Should use resources otherwise.
     */
    override fun getPageTitle(position: Int): CharSequence {
        when (position) {
            0 -> return "Monday"
            1 -> return "Tuesday"
            2 -> return "Wednesday"
            3 -> return "Thursday"
            4 -> return "Friday"
            else -> return "?"
        }
    }
}