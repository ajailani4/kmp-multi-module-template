package com.ajailani.kmpmultimodule.util

import io.ktor.client.engine.darwin.Darwin

actual val ktorEngine = Darwin.create()