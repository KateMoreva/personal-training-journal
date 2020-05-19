package ru.ok.technopolis.training.personal.viewholders

import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.item_active_exercise_element.view.*
import ru.ok.technopolis.training.personal.items.Parameter

class ActiveExerciseViewHolder(
    itemView: View
) : BaseViewHolder<Parameter>(itemView) {

    private var title: TextView = itemView.parameter
    private var goal: TextView = itemView.parameter_goal

    override fun bind(item: Parameter) {
        title.text = item.title
        goal.text = item.value.toString()
    }
}