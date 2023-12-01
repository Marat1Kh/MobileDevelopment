package com.example.fintech.domain.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface FireBaseAuthentication {
    fun signInWithEmailAndPassword(email: String, password: String): Task<AuthResult>
}
