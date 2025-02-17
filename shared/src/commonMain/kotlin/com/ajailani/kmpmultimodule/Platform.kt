package com.ajailani.kmpmultimodule

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform