package tr.xip.timetable

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_class.view.*
import tr.xip.timetable.model.Class
import tr.xip.timetable.util.TimeUtils
import tr.xip.timetable.util.getLayoutInflater

class ClassesAdapter(val day: Int, classes: List<Class>) : RecyclerView.Adapter<ClassesAdapter.ViewHolder>() {
    /**
     * Filtered list with only the classes for the given day
     */
    val dataset: List<Class> = classes.filter { it.day == day }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = parent.getLayoutInflater().inflate(R.layout.item_class, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset[position]

        holder.view.name.text = item.name ?: "?"
        holder.view.prof.text = item.prof ?: "?"
        holder.view.place.text = item.place ?: "?"
        holder.view.startTime.text = TimeUtils.getDisplayableTime(item.startTime ?: -1)
        holder.view.endTime.text = TimeUtils.getDisplayableTime(item.endTime ?: -1)

        // Increase item height for longer classes
        if (item.length > 1) {
            holder.view.layoutParams.height =
                    (holder.view.context.resources.getDimension(R.dimen.class_item_height) * 2).toInt()
        }
    }

    override fun getItemCount(): Int = dataset.size

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}