package com.zagart.compose.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    fun ioDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }
}