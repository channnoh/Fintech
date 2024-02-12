package com.springboot.api.test

import com.springboot.domain.domain.UserInfo
import com.springboot.domain.repository.UserInfoRepository
import org.springframework.stereotype.Service


@Service
class TestService(
        private val userInfoRepository: UserInfoRepository
) {
    fun testGetService(userKey: String) = userInfoRepository.findByUserKey(userKey).toDto()

    fun UserInfo.toDto() = TestDto.UserInfoDto(userKey, userRegistrationNumber, userName, userIncomeAmount)
}