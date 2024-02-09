package com.zagart.compose.presentation

import kotlin.reflect.KClass

sealed interface Event

class EventBus {

    private val subscriptions =
        mutableMapOf<KClass<out Event>, MutableSet<Any>>()

    fun <T : Event> subscribeOn(event: KClass<T>, subscriber: (T) -> Unit) {
        if (subscriptions.containsKey(event)) {
            subscriptions.getValue(event).add(subscriber)
        } else {
            subscriptions[event] = mutableSetOf(subscriber)
        }
    }

    @Suppress("UNCHECKED_CAST") //EventBus implementation guarantees cast safety
    fun <T : Event> dispatchEvent(event: T) {
        if (subscriptions.containsKey(event::class)) {
            subscriptions.getValue(event::class).forEach { subscriber ->
                (subscriber as (T) -> Unit).invoke(event)
            }
        }
    }

    fun clear() {
        subscriptions.clear()
    }
}