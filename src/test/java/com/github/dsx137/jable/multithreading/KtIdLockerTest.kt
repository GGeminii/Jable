package com.github.dsx137.jable.multithreading

import com.github.dsx137.jable.exception.CheckException
import com.github.dsx137.jable.extension.slf4j

class KtIdLockerTest {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val idLock = IdLock()
            val number = idLock.compute {
                println("1")
                1
            }
            slf4j.info("number: $number")
        }
    }

    fun checkUsernameSyntax(username: String?) {
        CheckException.check(
            "无效的用户名", username, listOf(
                "用户名不能为空" to { isNullOrEmpty() },
                "用户名必须为学号" to { this?.toInt() !in 2000000000..2030000000 },
            )
        )
    }
}