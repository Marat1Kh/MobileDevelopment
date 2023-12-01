//package com.example.fintech
//import com.example.fintech.data.login.LoginUIEvent
//import com.example.fintech.data.login.LoginViewModel
//import com.example.fintech.domain.repository.FireBaseAuthentication
//import com.google.android.gms.tasks.Task
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.AuthResult
//import org.junit.Before
//import org.junit.Test
//import org.mockito.Mock
//import org.mockito.MockitoAnnotations
//import org.mockito.kotlin.mock
//import org.mockito.kotlin.whenever
//import org.mockito.kotlin.verify
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.test.runTest
//import org.junit.runner.RunWith
//import org.robolectric.RobolectricTestRunner
//@RunWith(RobolectricTestRunner::class)
//class LoginViewModelTest {
//
//    @Mock
//    private lateinit var mockFirebaseAuth: FireBaseAuthentication
//
//    private lateinit var viewModel: LoginViewModel
//
//    @Before
//    fun setUp() {
//        MockitoAnnotations.openMocks(this)
//        viewModel = LoginViewModel(mockFirebaseAuth)
//    }
//
//    @Test
//    fun `login with valid credentials calls FirebaseAuthentication`() = runTest {
//        // Arrange
//        val email = "littlesmaax@gmail.com"
//        val password = "Makok123"
//        val mockTask: Task<AuthResult> = mock()
//        whenever(mockTask.isSuccessful).thenReturn(true)
//        whenever(mockFirebaseAuth.signInWithEmailAndPassword(email, password)).thenReturn(mockTask)
//
//        // Act
//        viewModel.onEvent(LoginUIEvent.EmailChanged(email))
//        viewModel.onEvent(LoginUIEvent.PasswordChanged(password))
//        viewModel.onEvent(LoginUIEvent.LoginButtonClicked)
//
//        // Assert
//        verify(mockFirebaseAuth).signInWithEmailAndPassword(email, password)
//    }
//}
