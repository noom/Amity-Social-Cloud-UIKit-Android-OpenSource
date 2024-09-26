package com.amity.socialcloud.uikit.community.views.profile

import android.content.Context
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.text.bold
import androidx.databinding.DataBindingUtil
import com.amity.socialcloud.sdk.model.core.follow.AmityFollowStatus
import com.amity.socialcloud.sdk.model.core.follow.AmityMyFollowInfo
import com.amity.socialcloud.sdk.model.core.follow.AmityUserFollowInfo
import com.amity.socialcloud.sdk.model.core.user.AmityUser
import com.amity.socialcloud.uikit.common.common.views.AmityColorPaletteUtil
import com.amity.socialcloud.uikit.common.common.views.AmityColorShade
import com.amity.socialcloud.uikit.community.R
import com.amity.socialcloud.uikit.community.databinding.AmityViewUserProfileHeaderBinding

class AmityUserProfileHeaderView : ConstraintLayout {
    private lateinit var headerBinding: AmityViewUserProfileHeaderBinding

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    fun setUserData(user: AmityUser) {
        headerBinding.amityUser = user
        headerBinding.postCount = "10"
        headerBinding.tvPostCount.setText(
            getStylisedText("10", context.getString(R.string.amity_posts)),
            TextView.BufferType.SPANNABLE
        )

        val banIcon = if (user.isGlobalBan()) {
            ContextCompat.getDrawable(context, R.drawable.amity_ic_ban)
        } else {
            null
        }
        headerBinding.tvName.setCompoundDrawablesRelativeWithIntrinsicBounds(
            null,
            null,
            banIcon,
            null
        )
    }

    fun setIsSelf(isSelf: Boolean) {
        headerBinding.isSelf = isSelf
    }

    fun getHeaderBinding(): AmityViewUserProfileHeaderBinding = headerBinding

    private fun init() {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        headerBinding =
            DataBindingUtil.inflate(inflater, R.layout.amity_view_user_profile_header, this, true)
    }

    private fun getStylisedText(s1: String, s2: String): Spannable {
        return SpannableStringBuilder()
            .bold { append(s1) }
            .append(' ')
            .append(s2)
    }
}
