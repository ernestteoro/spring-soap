package com.technolyne.springsoap.controller

import com.technolyne.springsoap.model.FilmRequest
import com.technolyne.springsoap.model.FilmResponse
import com.technolyne.springsoap.service.FilmService
import com.technolyne.springsoap.util.NAMESPACE
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ws.server.endpoint.annotation.Endpoint
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload

@Endpoint
class FilmController(
    @Autowired
    val filmService: FilmService
) {

    @PayloadRoot(namespace = NAMESPACE, localPart = "FilmRequest")
    @ResponsePayload
    fun getFilms(@RequestPayload filmRequest: FilmRequest):FilmResponse{
        return filmService.listFilm(filmRequest)
    }
}