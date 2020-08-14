package com.example.pagingproject.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StackResponse {

    @SerializedName("items")
    @Expose
    var items: List<Item>? = null
    @SerializedName("has_more")
    @Expose
    var hasMore: Boolean? = null
    @SerializedName("backoff")
    @Expose
    var backoff: Int? = null
    @SerializedName("quota_max")
    @Expose
    var quotaMax: Int? = null
    @SerializedName("quota_remaining")
    @Expose
    var quotaRemaining: Int? = null

}
