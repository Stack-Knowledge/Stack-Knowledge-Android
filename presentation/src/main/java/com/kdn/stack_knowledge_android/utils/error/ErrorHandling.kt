package com.kdn.stack_knowledge_android.utils.error

import android.util.Log
import com.kdn.domain.exception.ConflictDataException
import com.kdn.domain.exception.ForBiddenException
import com.kdn.domain.exception.InvalidTokenException
import com.kdn.domain.exception.NeedLoginException
import com.kdn.domain.exception.NotFoundException
import com.kdn.domain.exception.ServerErrorException
import com.kdn.domain.exception.TooManyRequestException
import com.kdn.domain.exception.WrongDataException


suspend fun<T> Throwable.errorHandling(
    unknownAction: suspend () -> Unit,
    wrongDataException: suspend () -> Unit = unknownAction,
    invalidTokenException: suspend () -> Unit = unknownAction,
    notFoundException: suspend () -> Unit = unknownAction,
    conflictException: suspend () -> Unit = unknownAction,
    serverErrorException: suspend () -> Unit = unknownAction,
    needLoginException: suspend () -> Unit = unknownAction,
    tooManyRequestException: suspend () -> Unit = unknownAction,
    forBiddenException: suspend() -> Unit = unknownAction,
): Event<T> =
    when (this) {
        is WrongDataException -> {
            errorLog("WrongDataException", message)
            wrongDataException()
            Event.BadRequest
        }

        is InvalidTokenException -> {
            errorLog("InvalidTokenException", message)
            invalidTokenException()
            Event.Unauthorized
        }

        is NotFoundException -> {
            errorLog("NotFoundException", message)
            notFoundException()
            Event.NotFound
        }

        is ForBiddenException -> {
            errorLog("ForbiddenExceptiom", message)
            forBiddenException()
            Event.ForBidden
        }
        is ConflictDataException -> {
            errorLog("ConflictDataException", message)
            conflictException()
            Event.Conflict
        }

        is ServerErrorException -> {
            errorLog("ServerErrorException", message)
            serverErrorException()
            Event.Server
        }

        is NeedLoginException -> {
            errorLog("NeedLoginException", message)
            needLoginException()
            Event.TokenExpired
        }

        is TooManyRequestException -> {
            errorLog("TooManyRequestException", message)
            tooManyRequestException()
            Event.ManyRequest
        }

        else -> {
            errorLog("UnKnownException", message)
            unknownAction()
            Event.UnKnown
        }
    }

private fun errorLog(tag: String, kdn: String?) {
    Log.e(tag, kdn ?: "")
}
