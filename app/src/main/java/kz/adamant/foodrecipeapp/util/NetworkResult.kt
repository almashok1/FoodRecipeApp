package kz.adamant.foodrecipeapp.util

sealed class NetworkResult<out T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T): NetworkResult<T>(data)
    class Error<T>(message: String?, data: T? = null) : NetworkResult<T>(data, message)
    object Loading: NetworkResult<Nothing>()
}