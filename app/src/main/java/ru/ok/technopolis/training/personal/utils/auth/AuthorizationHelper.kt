package ru.ok.technopolis.training.personal.utils.auth

import ru.ok.technopolis.training.personal.model.UserSignUpInfo

object AuthorizationHelper {

    private const val EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$"

    private const val PASSWORD_PATTERN = "[a-zA-Z0-9_/!?&*.,]{6,}"

    private const val NAME_PATTERN = "^\\S{2,}\$"

    @SignUpDataCorrectType
    fun checkCorrectnessInputData(userSignUpInfo: UserSignUpInfo): Int {
        return if (!isCorrectEmail(userSignUpInfo.email)) {
            SignUpDataCorrectType.INCORRECT_EMAIL
        } else if (!isCorrectPassword(userSignUpInfo.password)) {
            SignUpDataCorrectType.INCORRECT_PASSWORD
        } else if (userSignUpInfo.password != userSignUpInfo.confirmPassword) {
            SignUpDataCorrectType.INCORRECT_CONFIRM_PASSWORD
        } else if (!isCorrectName(userSignUpInfo.lastName)) {
            SignUpDataCorrectType.INCORRECT_LAST_NAME
        } else if (!isCorrectName(userSignUpInfo.firstName)) {
            SignUpDataCorrectType.INCORRECT_FIRST_NAME
        } else {
            SignUpDataCorrectType.CORRECT
        }
    }

    private fun isCorrectName(name: String): Boolean = name.matches(Regex(NAME_PATTERN))

    private fun isCorrectPassword(password: String): Boolean = password.matches(Regex(PASSWORD_PATTERN))

    private fun isCorrectEmail(email: String): Boolean = email.matches(Regex(EMAIL_PATTERN))
}