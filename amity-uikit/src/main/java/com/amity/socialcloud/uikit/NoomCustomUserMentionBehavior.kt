package com.amity.socialcloud.uikit

import android.content.Context
import com.amity.socialcloud.uikit.community.compose.NoomUserMentionBehavior
import com.amity.socialcloud.uikit.community.profile.activity.AmityUserProfileActivity

class NoomCustomUserMentionBehavior : NoomUserMentionBehavior() {
    override fun goToUserProfilePage(context: Context, userId: String) {
        val intent = AmityUserProfileActivity.newIntent(
            context = context,
            id = userId,
        )
        context.startActivity(intent)
    }
}
