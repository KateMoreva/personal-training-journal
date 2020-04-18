package ru.ok.technopolis.training.personal.activities

import androidx.preference.PreferenceFragmentCompat
import ru.ok.technopolis.training.personal.R
import ru.ok.technopolis.training.personal.fragments.AccountSettingsFragment

class AccountSettingsActivity : BaseSettingsActivity() {

    override fun hasNavigationMenu(): Boolean = false

    override fun getToolbarTitle(): String = getString(R.string.account_settings)

    override fun getPreferencesFragment(): PreferenceFragmentCompat = AccountSettingsFragment()
}