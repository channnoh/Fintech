package com.springboot.domain.repository

import com.springboot.domain.domain.UserInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


interface UserInfoRepository : JpaRepository<UserInfo, Long>{
    fun findByUserKey(userKey: String): UserInfo
}