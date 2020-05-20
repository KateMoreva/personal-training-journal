package ru.ok.technopolis.training.personal.utils.toast

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import ru.ok.technopolis.training.personal.R

object ToastUtils {

    fun showErrorToast(context: Context) {
        Toast.makeText(context, R.string.error, Toast.LENGTH_LONG).show()
    }

    fun showLongToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

    fun showLongToast(context: Context, @StringRes stringRes: Int) {
        ToastUtils.showLongToast(context, context.getString(stringRes))
    }

    fun showShortToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun showShortToast(context: Context, @StringRes stringRes: Int) {
        ToastUtils.showShortToast(context, context.getString(stringRes))
    }
}