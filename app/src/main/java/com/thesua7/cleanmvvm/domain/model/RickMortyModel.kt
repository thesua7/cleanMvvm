package com.thesua7.cleanmvvm.domain.model

import com.thesua7.cleanmvvm.data.dto.Result

data class RickMortyModel(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun Result.toDomain() = RickMortyModel(
    created = created,
    episode = episode,
    gender = gender,
    id = id,
    image = image,
    name = name,
    species = species,
    status = status,
    type = type,
    url = url
)
