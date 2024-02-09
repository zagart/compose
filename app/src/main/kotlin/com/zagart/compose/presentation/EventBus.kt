package com.zagart.compose.presentation

sealed interface Event
typealias Subscriber = (Event) -> Unit

class EventBus {

    private val subscriptions =
        mutableMapOf<Event, MutableSet<Subscriber>>()

    fun subscribeOn(event: Event, subscriber: Subscriber) {
        if (subscriptions.containsKey(event)) {
            subscriptions.getValue(event).add(subscriber)
        } else {
            subscriptions[event] = mutableSetOf(subscriber)
        }
    }

    fun dispatchEvent(event: Event) {
        if (subscriptions.containsKey(event)) {
            subscriptions.getValue(event).forEach { subscriber ->
                subscriber(event)
            }
        }
    }

    fun clear() {
        subscriptions.clear()
    }
}