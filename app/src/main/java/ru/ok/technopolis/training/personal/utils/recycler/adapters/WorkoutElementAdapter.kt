package ru.ok.technopolis.training.personal.utils.recycler.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.utils.recycler.elements.WorkoutElement

class WorkoutElementAdapter(private var elements: List<WorkoutElement>, private val onClick: ((v: View?) -> Unit)?)
    : RecyclerView.Adapter<WorkoutElementAdapter.WorkoutElementHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutElementHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_workout_element, parent, false)
        view.setOnClickListener(onClick)
        return WorkoutElementHolder(view)
    }

    override fun getItemCount(): Int {
        return elements.size
    }

    override fun onBindViewHolder(holder: WorkoutElementHolder, position: Int) {
        holder.bind(elements[position])
    }

    class WorkoutElementHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var icon: ImageView = itemView.findViewById(R.id.item_workout_element__icon)
        private var title: TextView = itemView.findViewById(R.id.item_workout_element__title)
        private var description: TextView = itemView.findViewById(R.id.item_workout_element__description)

        fun bind(element: WorkoutElement) {
            icon.setImageResource(element.iconId)
            title.text = element.title
            description.text = element.description
        }
    }
}