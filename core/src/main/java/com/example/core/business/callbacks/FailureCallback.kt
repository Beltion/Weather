package com.example.core.business.callbacks

interface FailureCallback {
    fun onFailure(tag: String, error: Any?)
}