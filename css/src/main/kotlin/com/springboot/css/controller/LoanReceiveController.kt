package com.springboot.css.controller

import com.springboot.css.dto.LoanRequestDto
import com.springboot.css.dto.LoanResultDto
import com.springboot.css.service.LoanReviewService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/css/api/v1")
class LoanReceiveController(
        private val loanReviewService: LoanReviewService
) {
    @PostMapping("/request")
    fun loanReceive(
            @RequestBody requestInputDto: LoanRequestDto.RequestInputDto
    ): LoanResultDto.ResponseDto =
            loanReviewService.loanReview(requestInputDto)
}