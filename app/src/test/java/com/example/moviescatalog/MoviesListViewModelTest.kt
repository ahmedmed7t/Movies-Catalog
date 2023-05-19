package com.example.moviescatalog

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.moviescatalog.list_screen.domain.models.LoadMoviesState
import com.example.moviescatalog.list_screen.domain.usecases.LoadPopularMoviesListUseCase
import com.example.moviescatalog.list_screen.domain.usecases.LoadRevenueMoviesListUseCase
import com.example.moviescatalog.list_screen.domain.usecases.LoadTopRatedMoviesListUseCase
import com.example.moviescatalog.list_screen.presentation.MoviesListViewModel
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MoviesListViewModelTest {

    // Use a test dispatcher for coroutines
    private val testDispatcher = TestCoroutineDispatcher()

    // Use a test coroutine scope
    private val testCoroutineScope = TestCoroutineScope(testDispatcher)

    // Provide a rule to swap the background executor for testing LiveData
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    // Mock dependencies
    private val popularMoviesListUseCase: LoadPopularMoviesListUseCase = mockk()
    private val topRatedMoviesListUseCase: LoadTopRatedMoviesListUseCase = mockk()
    private val revenueMoviesListUseCase: LoadRevenueMoviesListUseCase = mockk()

    // Create a mock observer for the state LiveData
    private val stateObserver: Observer<LoadMoviesState> = mockk(relaxed = true)

    // Create an instance of the view model
    private lateinit var viewModel: MoviesListViewModel

    @Before
    fun setup() {
        // Initialize the view model with mocked dependencies
        viewModel = MoviesListViewModel(
            popularMoviesListUseCase,
            topRatedMoviesListUseCase,
            revenueMoviesListUseCase
        )

        // Observe the state LiveData
        viewModel.popularMoviesListState.observeForever(stateObserver)
        viewModel.topRatedMoviesListState.observeForever(stateObserver)
        viewModel.revenueMoviesListState.observeForever(stateObserver)

        // Set the test dispatcher as the default for coroutines
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun cleanup() {
        // Clear all co-routines jobs
        testCoroutineScope.cleanupTestCoroutines()

        // Reset the test dispatcher
        Dispatchers.resetMain()

        // Clear all mocked calls and verify no more interactions
        clearAllMocks()
    }

    @Test
    fun `loadPopularMovies should update popularMoviesListState with success response`() = runBlockingTest {
        val newState = LoadMoviesState.MoviesSuccessResponse(
            arrayListOf(),
            10
        )
        coEvery { popularMoviesListUseCase.loadMovies(any()) } returns newState

        val observer = mockk<Observer<LoadMoviesState>>()
        every { observer.onChanged(any()) } just Runs
        viewModel.popularMoviesListState.observeForever(observer)

        viewModel.loadPopularMovies()

        val expectedState = LoadMoviesState.MoviesSuccessResponse(
            arrayListOf(),
            10
        )
        verify { observer.onChanged(expectedState) }

        viewModel.popularMoviesListState.removeObserver(observer)
    }

    @Test
    fun `loadPopularMovies should update popularMoviesListState with fail response`() = runBlockingTest {
        val newState = LoadMoviesState.MoviesFailResponse(
           "Error"
        )
        coEvery { popularMoviesListUseCase.loadMovies(any()) } returns newState

        val observer = mockk<Observer<LoadMoviesState>>()
        every { observer.onChanged(any()) } just Runs
        viewModel.popularMoviesListState.observeForever(observer)

        viewModel.loadPopularMovies()

        val expectedState = LoadMoviesState.MoviesFailResponse(
            "Error"
        )
        verify { observer.onChanged(expectedState) }

        viewModel.popularMoviesListState.removeObserver(observer)
    }

    @Test
    fun `loadTopRatedMovies should update popularMoviesListState with success response`() = runBlockingTest {
        val newState = LoadMoviesState.MoviesSuccessResponse(
            arrayListOf(),
            10
        )
        coEvery { topRatedMoviesListUseCase.loadMovies(any()) } returns newState

        val observer = mockk<Observer<LoadMoviesState>>()
        every { observer.onChanged(any()) } just Runs
        viewModel.topRatedMoviesListState.observeForever(observer)

        viewModel.loadTopRatedMovies()

        val expectedState = LoadMoviesState.MoviesSuccessResponse(
            arrayListOf(),
            10
        )
        verify { observer.onChanged(expectedState) }

        viewModel.topRatedMoviesListState.removeObserver(observer)
    }

    @Test
    fun `loadTopRatedMovies should update popularMoviesListState with fail response`() = runBlockingTest {
        val newState = LoadMoviesState.MoviesFailResponse(
            "Error"
        )
        coEvery { topRatedMoviesListUseCase.loadMovies(any()) } returns newState

        val observer = mockk<Observer<LoadMoviesState>>()
        every { observer.onChanged(any()) } just Runs
        viewModel.topRatedMoviesListState.observeForever(observer)

        viewModel.loadTopRatedMovies()

        val expectedState = LoadMoviesState.MoviesFailResponse(
            "Error"
        )
        verify { observer.onChanged(expectedState) }

        viewModel.topRatedMoviesListState.removeObserver(observer)
    }

    @Test
    fun `loadRevenueMovies should update popularMoviesListState with success response`() = runBlockingTest {
        val newState = LoadMoviesState.MoviesSuccessResponse(
            arrayListOf(),
            10
        )
        coEvery { revenueMoviesListUseCase.loadMovies(any()) } returns newState

        val observer = mockk<Observer<LoadMoviesState>>()
        every { observer.onChanged(any()) } just Runs
        viewModel.revenueMoviesListState.observeForever(observer)

        viewModel.loadRevenueMovies()

        val expectedState = LoadMoviesState.MoviesSuccessResponse(
            arrayListOf(),
            10
        )
        verify { observer.onChanged(expectedState) }

        viewModel.revenueMoviesListState.removeObserver(observer)
    }

    @Test
    fun `loadRevenueMovies should update popularMoviesListState with fail response`() = runBlockingTest {
        val newState = LoadMoviesState.MoviesFailResponse(
            "Error"
        )
        coEvery { revenueMoviesListUseCase.loadMovies(any()) } returns newState

        val observer = mockk<Observer<LoadMoviesState>>()
        every { observer.onChanged(any()) } just Runs
        viewModel.revenueMoviesListState.observeForever(observer)

        viewModel.loadRevenueMovies()

        val expectedState = LoadMoviesState.MoviesFailResponse(
            "Error"
        )
        verify { observer.onChanged(expectedState) }

        viewModel.revenueMoviesListState.removeObserver(observer)
    }
}
