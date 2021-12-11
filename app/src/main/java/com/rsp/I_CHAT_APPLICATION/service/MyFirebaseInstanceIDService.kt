package com.rsp.I_CHAT_APPLICATION.service

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.messaging.FirebaseMessagingService
import com.rsp.I_CHAT_APPLICATION.util.FirestoreUtil



class MyFirebaseInstanceIDService: FirebaseMessagingService() {

    override fun onNewToken(p0: String) {

        super.onNewToken(p0)
        Log.d("NEW_TOKEN", p0)


        if (FirebaseAuth.getInstance().currentUser != null)
            addTokenToFirestore(p0)
    }

    companion object {
        fun addTokenToFirestore(newRegistrationToken: String?) {
            if(newRegistrationToken == null) throw NullPointerException("FCM token is null")

            FirestoreUtil.getFCMRegistrationTokens {tokens ->  
                if(tokens.contains(newRegistrationToken))
                    return@getFCMRegistrationTokens

                // update firestore with 'new' tokens
                tokens.add(newRegistrationToken)
                FirestoreUtil.setFCMRegistrationTokens(tokens)
            }
        }
    }
}