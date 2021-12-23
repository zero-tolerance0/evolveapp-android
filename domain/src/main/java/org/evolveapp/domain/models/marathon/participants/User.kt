package org.evolveapp.domain.models.marathon.participants


data class User(
    val id: Int? = null,
    val username: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val avatar: String? = null,
    val firstTime: Boolean? = null
)