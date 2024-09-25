package com.amity.socialcloud.uikit.community.compose

import android.content.Context

open class NoomUserMentionBehavior {
    open fun goToUserProfilePage(
        context: Context,
        userId: String,
    ) {
        //  do nothing, need to override in social module to access user profile page
    }
}
