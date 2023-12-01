package com.example.fintech.data

/**
 * Registration UI states
 * @property firstName
 * @property lastName
 * @property email
 * @property password
 * @property privacyPolicyAccepted
 * @property firstNameError
 * @property lastNameError
 * @property emailError
 * @property passwordError
 * @property privacyPolicyError
 */
data class RegistrationUIState(
    var firstName :String = "",
    var lastName  :String = "",
    var email  :String = "",
    var password  :String = "",
    var privacyPolicyAccepted :Boolean = false,


    var firstNameError :Boolean = false,
    var lastNameError : Boolean = false,
    var emailError :Boolean = false,
    var passwordError : Boolean = false,
    var privacyPolicyError:Boolean = false


)
