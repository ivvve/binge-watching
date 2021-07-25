package com.tistory.devs0n.bingewatching.domain.member.common.utils

fun CharSequence.hasSpace(): Boolean {
    return this.contains(' ')
}

fun CharSequence.hasLengthBetween(min: Int, max: Int): Boolean {
    return (min <= this.length) && (this.length <= max)
}
