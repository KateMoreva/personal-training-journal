package ru.ok.technopolis.training.personal.fragments

import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_calendar.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.db.entity.WorkoutEntity
import ru.ok.technopolis.training.personal.items.ItemsList
import ru.ok.technopolis.training.personal.utils.recycler.adapters.CalendarWorkoutListAdapter
import ru.ok.technopolis.training.personal.viewholders.WorkoutViewHolder

class CalendarFragment : BaseFragment() {

    var calendar: CalendarView? = null
    var addWorkoutButton: ImageView? = null
    var recyclerView: RecyclerView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        calendar = view.calendar

        addWorkoutButton = view.add_workout_button
        recyclerView = view.workout_list

        GlobalScope.launch(Dispatchers.IO) {
            val workoutList = database?.workoutDao()?.getAll()!!

            withContext(Dispatchers.Main) {
                val elements = ItemsList(workoutList)

                val workoutAdapter = CalendarWorkoutListAdapter(
                    holderType = WorkoutViewHolder::class,
                    layoutId = R.layout.item_workout,
                    dataSource = elements,
                    onClick = {
                        router?.showWorkoutPage(it.id)
                    },
                    onStartWorkoutClick = {
                        router?.showActiveExercisePage()
                    },
                    onDeleteWorkoutClick = {
                        GlobalScope.launch(Dispatchers.IO) {
                            database?.workoutDao()?.delete(it)
                            withContext(Dispatchers.Main) {
                                elements.remove(it)
                            }
                        }
                    }
                )

                recyclerView?.adapter = workoutAdapter
                recyclerView?.layoutManager = LinearLayoutManager(activity)
                recyclerView?.addItemDecoration(DividerItemDecoration(activity, LinearLayout.VERTICAL))

                addWorkoutButton?.setOnClickListener {
                    GlobalScope.launch(Dispatchers.IO) {
                        val workoutEntity = WorkoutEntity("", "")
                        workoutEntity.id = database?.workoutDao()?.insert(workoutEntity)!!
                        withContext(Dispatchers.Main) {
                            elements.add(
                                workoutEntity
                            )
                            router?.showWorkoutPage(workoutEntity.id)
                        }
                    }
                }
            }
        }
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_calendar
}