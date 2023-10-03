package com.kdn.data.local.auth.datasource

import kotlinx.coroutines.flow.Flow

interface LocalAuthDataSource {
    // AccessToken
    suspend fun getAccessToken(): Flow<String>
    suspend fun setAccessToken(accessToken: String)
    suspend fun removeAccessToken()

    // RefreshToken
    suspend fun getRefreshToken(): Flow<String>
    suspend fun setRefreshToken(refreshToken: String)
    suspend fun removeRefreshToken()

    // ExpiredAt
    suspend fun getExpiredAt(): Flow<String>
    suspend fun setExpiredAt(ExpiredAt: String)
    suspend fun removeExpiredAt()

    // Authority
    suspend fun getAuthorityInfo(): Flow<String>
    suspend fun setAuthorityInfo(authority: String)
    suspend fun removeAuthorityInfo()
}