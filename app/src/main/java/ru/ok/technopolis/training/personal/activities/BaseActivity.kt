package ru.ok.technopolis.training.personal.activities

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import com.facebook.drawee.backends.pipeline.Fresco
import io.reactivex.disposables.CompositeDisposable
import ru.ok.technopolis.training.personal.lifecycle.Router
import ru.ok.technopolis.training.personal.utils.logger.Logger

abstract class BaseActivity : AppCompatActivity() {

    var router: Router? = null
        private set

    protected val taskContainer: CompositeDisposable = CompositeDisposable()

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        Logger.d(this, "onCreate")

        router = Router(this)

        setContentView(getActivityLayoutId())
    }

    override fun onDestroy() {
        super.onDestroy()
        taskContainer.dispose()
    }

    protected abstract fun getActivityLayoutId(): Int
}