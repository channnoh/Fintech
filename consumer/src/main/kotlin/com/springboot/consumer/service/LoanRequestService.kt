package com.springboot.consumer.service

import com.springboot.consumer.dto.ReviewResponseDto
import com.springboot.domain.domain.LoanReview
import com.springboot.domain.repository.LoanReviewRepository
import com.springboot.kafka.dto.LoanRequestDto
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class LoanRequestService(
        private val loanReviewRepository: LoanReviewRepository
) {
    companion object {
        const val cssUrl = "http://nginx:8085/css/api/v1/request"
    }

    fun loanRequest(loanRequestDto: LoanRequestDto) {
        val reviewResult = loanRequestToCb(loanRequestDto)

        saveLoanReviewData(reviewResult.toLoanReviewEntity())
    }

    private fun loanRequestToCb(loanRequestDto: LoanRequestDto): ReviewResponseDto {
        val restTemplate = RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(1000))
                .setReadTimeout(Duration.ofMillis(1000))
                .build()

        return restTemplate.postForEntity(cssUrl, loanRequestDto, ReviewResponseDto::class.java).body!!
    }

    private fun saveLoanReviewData(loanReview: LoanReview) = loanReviewRepository.save(loanReview)
}