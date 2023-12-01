//package com.example.fintech
//
//import androidx.lifecycle.SavedStateHandle
//import com.example.fintech.data.signup.SignupUIEvent
//import com.example.fintech.data.signup.SignupViewModel
//import com.google.firebase.auth.AuthResult
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.FirebaseUser
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.test.runTest
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.mockito.Mock
//import org.mockito.MockitoAnnotations
//import org.mockito.kotlin.mock
//import org.mockito.kotlin.verify
//import org.mockito.kotlin.whenever
//import org.mockito.junit.MockitoJUnitRunner
//
//@ExperimentalCoroutinesApi
//@RunWith(MockitoJUnitRunner::class)
//class SignupViewModelTest {
//
//    @Mock
//    private lateinit var mockFirebaseAuth: FirebaseAuth
//
//    private lateinit var viewModel: SignupViewModel
//
//    @Before
//    fun setUp() {
//        MockitoAnnotations.openMocks(this)
//        viewModel = SignupViewModel(SavedStateHandle()) // Pass any initial state if required
//        // Assume FirebaseAuth.getInstance() returns the mock instance
//        whenever(FirebaseAuth.getInstance()).thenReturn(mockFirebaseAuth)
//    }
//
//    @Test
//    fun `when first name is entered, first name state is updated`() = runTest {
//        // Arrange
//        val firstName = "John"
//
//        // Act
//        viewModel.onEvent(SignupUIEvent.FirstNameChanged(firstName))
////
//        // Assert
//        assert(viewModel.registrationUIState.value.firstName == firstName)
//    }
//
//    @Test
//    fun `when register button is clicked, firebase create user is called`() = runTest {
//        // Arrange
//        val email = "test@example.com"
//        val password = "password"
//        viewModel.onEvent(SignupUIEvent.EmailChanged(email))
//        viewModel.onEvent(SignupUIEvent.PasswordChanged(password))
//        // Mock FirebaseUser
//        val mockFirebaseUser = mock<FirebaseUser>()
//        // Mock the auth result
//        val authResult = mock<Task<AuthResult>>().apply {
//            whenever(isSuccessful).thenReturn(true)
//            whenever(result).thenReturn(mock())
//            whenever(result.user).thenReturn(mockFirebaseUser)
//        }
//        // Mock createUserWithEmailAndPassword
//        whenever(mockFirebaseAuth.createUserWithEmailAndPassword(email, password))
//            .thenReturn(authResult)
//
//        // Act
//        viewModel.onEvent(SignupUIEvent.RegisterButtonClicked)
//
//        // Assert
//        verify(mockFirebaseAuth).createUserWithEmailAndPassword(email, password)
//        // Assert that sign-up in progress is updated
//        assert(viewModel.signUpInProgress.value)
//    }
//
//    // Additional tests for last name, email, password and other events...
//}