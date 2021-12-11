package com.rsp.I_CHAT_APPLICATION.model

data class ChatChannel(val userIds: MutableList<String>) {
    constructor(): this(mutableListOf())
}