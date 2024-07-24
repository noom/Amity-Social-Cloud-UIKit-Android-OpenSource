package com.amity.socialcloud.uikit.markup

import android.text.Spanned
import com.amity.socialcloud.sdk.model.social.post.AmityPost

interface PostMarkupProcessor {
  fun toSpannedText(post: AmityPost): Spanned
}
