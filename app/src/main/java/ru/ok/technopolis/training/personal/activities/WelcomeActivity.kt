package ru.ok.technopolis.training.personal.activities

import android.content.Context
import android.os.Bundle
import ru.ok.technopolis.training.personal.R

class WelcomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: this is the mock for authorisation, implement this later
        val authorised = getSharedPreferences("Training", Context.MODE_PRIVATE).getBoolean("isAuthorised", false)

        if (authorised) {
            router?.showWorkoutPage()
        } else {
            router?.showLoginPage()
        }
        finish()
    }

    override fun getActivityLayoutId() = R.layout.activity_welcome
}