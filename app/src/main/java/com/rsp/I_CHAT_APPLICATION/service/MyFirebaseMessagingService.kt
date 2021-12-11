package com.rsp.I_CHAT_APPLICATION.service

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


// This is where we will receive messages from the Firebase Cloud Messaging
class MyFirebaseMessagingService: FirebaseMessagingService() {

    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)
        print("On message received called")
        if(p0?.notification != null) {
            // show notification if we are not in the chat channel from which the incoming message was sent
            Log.d("FCM", p0.data.toString())
        }
    }
}