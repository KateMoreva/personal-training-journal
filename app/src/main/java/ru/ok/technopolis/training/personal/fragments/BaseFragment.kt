package ru.ok.technopolis.training.personal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.room.RoomDatabase
import ru.ok.technopolis.training.personal.activities.BaseActivity
import ru.ok.technopolis.training.personal.db.AppDatabase
import ru.ok.technopolis.training.personal.lifecycle.Router

abstract class BaseFragment : Fragment() {

    protected var router: Router? = null
    protected var database: AppDatabase? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        router = (activity as BaseActivity).router
        database = (activity as BaseActivity).database
        return inflater.inflate(getFragmentLayoutId(), container, false) as ViewGroup
    }

    abstract fun getFragmentLayoutId(): Int
}
