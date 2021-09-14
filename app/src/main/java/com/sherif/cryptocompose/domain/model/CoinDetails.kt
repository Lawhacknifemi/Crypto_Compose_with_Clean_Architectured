package com.sherif.cryptocompose.domain.model

import com.sherif.cryptocompose.core.remote.dto.*
import com.google.gson.annotations.SerializedName

data class CoinDetails(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
    )
