package com.springboot.api.loan.review

import com.springboot.domain.domain.LoanReview

interface LoanReviewService {
    fun loanReviewMain(userKey: String): LoanReviewDto.LoanReviewResponseDto

    fun getLoanResult(userKey: String): LoanReview?
}