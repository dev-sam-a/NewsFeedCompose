package com.sinful.vkcompose

import androidx.compose.runtime.Composable
import com.vk.id.VKIDAuthFail
import com.vk.id.onetap.compose.onetap.OneTap
import com.vk.id.onetap.compose.onetap.OneTapTitleScenario

@Composable
fun ScreenWithVKIDButton() {
    OneTap(
        scenario = OneTapTitleScenario.SignUp,
        onAuth = { oAuth, token->

        },
        onFail = { oAuth, fail ->
            when (fail) {
                is VKIDAuthFail.Canceled -> TODO()
                is VKIDAuthFail.FailedApiCall -> TODO()
                is VKIDAuthFail.FailedOAuthState -> TODO()
                is VKIDAuthFail.FailedRedirectActivity -> TODO()
                is VKIDAuthFail.NoBrowserAvailable -> TODO()
                is VKIDAuthFail.FailedOAuth -> TODO()
            }
        })
    )
}