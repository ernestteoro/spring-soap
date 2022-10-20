package com.technolyne.springsoap.service

import com.technolyne.springsoap.model.FilmRequest
import com.technolyne.springsoap.model.FilmResponse
import com.technolyne.springsoap.repository.FilmRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FilmService(
    @Autowired
    val filmRepository: FilmRepository
) {

    fun listFilm(filmRequest: FilmRequest):FilmResponse{
        return filmRepository.listFilms(filmRequest)
    }
}