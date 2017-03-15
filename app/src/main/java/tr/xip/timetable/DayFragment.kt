package tr.xip.timetable

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_day.*
import tr.xip.timetable.model.Class

class DayFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_day, container, false)
    }

    @Suppress("UNCHECKED_CAST")
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val day = arguments?.getInt(ARG_DAY)
        val timetable = arguments?.getSerializable(ARG_TIMETABLE)

        if (day == null || timetable == null) return

        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = ClassesAdapter(day, timetable as List<Class>)
    }

    companion object {
        val ARG_DAY = "day"
        val ARG_TIMETABLE = "timetable"

        fun new(day: Int, timetable: ArrayList<Class>): DayFragment {
            val fragment = DayFragment()
            val arguments = Bundle()
            arguments.putInt(ARG_DAY, day)
            arguments.putSerializable(ARG_TIMETABLE, timetable)
            fragment.arguments = arguments
            return fragment
        }
    }
}