package com.springboot.api.loan.request

import com.springboot.domain.domain.UserInfo

interface LoanRequestService {
    fun loanRequestMain(
            loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestResponseDto

    fun saveUserInfo(
            userInfoDto: UserInfoDto
    ): UserInfo

    fun loanRequestReview(userInfoDto: UserInfoDto)
}