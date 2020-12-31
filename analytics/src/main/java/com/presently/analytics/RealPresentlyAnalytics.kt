package com.presently.analytics

import android.os.Bundle
import javax.inject.Inject

class RealPresentlyAnalytics @Inject constructor(private val countly: CountlyAnalytics, private val firebase: com.presently.analytics.FirebaseAnalytics) : PresentlyAnalytics {
    override fun recordEvent(event: String) {
        countly.recordEvent(event)
        firebase.logEvent(event)
    }

    override fun recordEvent(event: String, details: Map<String, Any>) {
        countly.recordEvent(event, details)
        val bundle = Bundle()
        for (item in details) {
            when (item.value) {
                is String -> bundle.putString(item.key, item.value as String)
                is Int -> bundle.putInt(item.key, item.value as Int)
            }
        }
        firebase.logEvent(event, bundle)
    }

    override fun recordView(viewName: String) {
        countly.recordView(viewName)
    }

    override fun optOutOfAnalytics() {
        countly.removeConsentAll()
        //TODO persist this in shared preferences
    }

}