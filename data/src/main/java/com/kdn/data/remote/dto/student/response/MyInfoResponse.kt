package com.kdn.data.remote.dto.student.response

import com.google.gson.annotations.SerializedName
import com.kdn.domain.entity.student.MyInfoEntity
import java.util.UUID

data class MyInfoResponse(
    @SerializedName("id")
    val id: UUID,
    @SerializedName("currentPoint")
    val currentPoint: Int,
    @SerializedName("cumulatePoint")
    val cumulatePoint: Int,
    @SerializedName("user")
    val user: User,
) {
    data class User(
        @SerializedName("id")
        val id: UUID,
        @SerializedName("email")
        val email: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("profileImage")
        val profileImage: String?,
    )
}

fun MyInfoResponse.toEntity() = MyInfoEntity(
    id = id,
    currentPoint = currentPoint,
    cumulatePoint = cumulatePoint,
    user = MyInfoEntity.User(
        id = user.id,
        email = user.email,
        name = user.name,
        profileImage = user.profileImage,
    )
)
