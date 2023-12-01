package com.example.fintech.data.signup

/**
 * SignUp events
 *
 */
sealed class SignupUIEvent{

    /**
     * First name changed
     *
     * @property firstName
     */
    data class FirstNameChanged(val firstName:String) : SignupUIEvent()

    /**
     * Last name changed
     *
     * @property lastName
     */
    data class LastNameChanged(val lastName:String) : SignupUIEvent()

    /**
     * Email changed
     *
     * @property email
     */
    data class EmailChanged(val email:String): SignupUIEvent()

    /**
     * Password changed
     *
     * @property password
     */
    data class PasswordChanged(val password: String) : SignupUIEvent()

    /**
     * Privacy policy check box clicked
     *
     * @property status
     */
    data class PrivacyPolicyCheckBoxClicked(val status:Boolean) : SignupUIEvent()

    object RegisterButtonClicked : SignupUIEvent()
}
