package ru.ok.technopolis.training.personal.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_view_training.*
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.items.WorkoutItem
import ru.ok.technopolis.training.personal.utils.recycler.adapters.BaseListAdapter
import ru.ok.technopolis.training.personal.viewholders.WorkoutElementViewHolder

class TrainingViewFragment : BaseFragment() {

    private var startTrainingButton: Button? = null
    private var trainingCategoryView: ImageView? = null
    private var trainingNameText: TextView? = null
    private var exerciseList: RecyclerView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startTrainingButton = start_training_button
        trainingCategoryView = training_category
        trainingNameText = training_name
        exerciseList = exercises_list

        val elements = Observable.just(listOf(
                WorkoutItem("id1", R.drawable.ic_exercise_category_bg, "Title 1", "Sample description 1"),
                WorkoutItem("id2", R.drawable.ic_exercise_category_bg, "Title 2", "Sample description 2")
        ))

        val exerciseListAdapter = BaseListAdapter(
                holderType = WorkoutElementViewHolder::class,
                layoutId = R.layout.item_exercises_list,
                dataSource = elements,
                onClick = {
                    TODO("Write logic here")
                }
        )

        exerciseList?.adapter = exerciseListAdapter
        exerciseList?.layoutManager = LinearLayoutManager(activity)
        exerciseList?.addItemDecoration(DividerItemDecoration(activity, LinearLayout.VERTICAL))
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_view_training
}