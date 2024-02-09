package com.zagart.compose.data

import com.zagart.compose.presentation.EventBus
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun ioDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Provides
    fun composeEventBus(): EventBus {
        return EventBus()
    }
}