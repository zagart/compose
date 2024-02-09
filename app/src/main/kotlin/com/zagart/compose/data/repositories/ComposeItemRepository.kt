package com.zagart.compose.data.repositories

import com.zagart.compose.data.entities.ComposeItem
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.random.Random

class ComposeItemRepository @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher
) {
    suspend fun getItems(): Flow<Result<List<ComposeItem>>> {
        return flow {
            val items = mutableListOf<ComposeItem>()
            val random = Random(System.currentTimeMillis())

            repeat(10) {
                items.add(
                    ComposeItem(
                        id = random.nextInt().toString(),
                        name = random.nextInt().toString().substring(0..4)
                    )
                )
            }
            delay(3000)
            emit(Result.success(items))
        }.flowOn(ioDispatcher)
    }
}