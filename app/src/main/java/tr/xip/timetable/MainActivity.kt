package tr.xip.timetable

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import org.apache.commons.io.IOUtils
import tr.xip.timetable.model.Class
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val timetable = Gson().fromJson<ArrayList<Class>>(
                IOUtils.toString(assets.open("timetable.json"), "UTF-8"),
                object : TypeToken<ArrayList<Class>>() {}.type
        )

        if (timetable != null && timetable.isNotEmpty()) {
            pager.adapter = DaysPagerAdapter(timetable, supportFragmentManager)
            tabs.setupWithViewPager(pager)

            // Normalize day value - our adapter works with five days, the first day (0) being Monday.
            val today = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 2
            pager.currentItem = if (today in 0..4) today else 0
        }
    }
}
