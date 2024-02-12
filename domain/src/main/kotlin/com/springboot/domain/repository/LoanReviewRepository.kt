package com.springboot.domain.repository

import com.springboot.domain.domain.LoanReview
import org.springframework.data.jpa.repository.JpaRepository


interface LoanReviewRepository : JpaRepository<LoanReview, Long> {
    fun findByUserKey(userKey: String): LoanReview?
}