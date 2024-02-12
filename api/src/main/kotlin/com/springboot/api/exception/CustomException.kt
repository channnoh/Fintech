package com.springboot.api.exception

import java.lang.RuntimeException

class CustomException(val customErrorCode: CustomErrorCode) : RuntimeException()