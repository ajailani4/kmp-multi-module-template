package com.ajailani.kmpmultimodule.core.network.util

import io.ktor.client.engine.darwin.Darwin

actual val ktorEngine = Darwin.create()