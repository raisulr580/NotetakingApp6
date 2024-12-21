package com.example.notetakingapp

import android.content.Intent
import android.provider.Settings.Global.getString
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.privacysandbox.tools.core.generator.build
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task

val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
    .requestIdToken(getString(R.string.default_web_client_id))
    .requestEmail()
    .build()

fun <ContentResolver> getString(defaultWebClientId: ContentResolver?): String? {

}

val googleSignInClient = GoogleSignIn.getClient(this, gso)
fun newFunction() {
    val signInButton = null
    signInButton.setOnClickListener {
        val signInIntent = googleSignInClient.signInIntent
        val RC_SIGN_IN = null
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }
}

override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)

    val RC_SIGN_IN = null
    if (requestCode == RC_SIGN_IN) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
        handleSignInResult(task)
    }
}

private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
    try {
        val account = completedTask.getResult(ApiException::class.java)
        // Signed in successfully, proceed with account details
    } catch (e: ApiException) {
        // Sign-in failed, handle error
    }
}