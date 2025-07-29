package org.example.project.presentation.component

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.shared.utils.Results
import kotlinx.coroutines.flow.StateFlow


@Composable
fun <T : Any> MultiStateView(
    modifier: Modifier = Modifier,
    state: StateFlow<Results<T>>,
    loadingLayout: @Composable (BoxScope.() -> Unit)? = null,
    errorLayout: @Composable (BoxScope.(code: Int?, messages: String?) -> Unit?)? = null,
    connectionLayout: @Composable (BoxScope.(messages: String?) -> Unit?)? = null,
    content: @Composable BoxScope.(data: T) -> Unit,
) {
    Crossfade(
        targetState = state.collectAsState().value,
        modifier = modifier, label = ""
    ) {
        when (val states = it) {
            is Results.Success -> Box {
                content.invoke(this, states.data)
            }
            is Results.Loading -> Box(
                modifier = Modifier.fillMaxSize()
            ) {
                loadingLayout?.invoke(this) ?: DefaultLoadingLayout()
            }
            is Results.Error -> Box(
                modifier = Modifier.fillMaxSize()
            ) {
                errorLayout?.invoke(this, states.code, states.message) ?: DefaultErrorLayout(states.code, states.message)
            }
//            is Results.Failure -> Box(
//                modifier = Modifier.fillMaxSize()
//            ) {
//                errorLayout?.invoke(this, states.throwable, states.message) ?: DefaultErrorLayout(states.throwable, states.message)
//            }
            is Results.Connection -> Box(
                modifier = Modifier.fillMaxSize()
            ) {
                connectionLayout?.invoke(this, states.message) ?: DefaultConnectionLayout(states.message){}
            }
            else -> {}
        }
    }
}

@Composable
fun DefaultLoadingLayout() {
    // Default loading layout implementation
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}
@Composable
fun DefaultErrorLayout(code: Int?, message: String?) {
    // Default error layout implementation
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = code.toString() ?: "0")
        Text(text = message ?: "An error occurred")
    }
}

@Composable
fun DefaultConnectionLayout(message: String?, function: () -> Unit) {
    // Default error layout implementation
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = message ?: "An error occurred")
    }
}