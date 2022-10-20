package com.technolyne.springsoap.repository

import com.technolyne.springsoap.model.Film
import com.technolyne.springsoap.model.FilmRequest
import com.technolyne.springsoap.model.FilmResponse
import org.springframework.stereotype.Service

@Service
class FilmRepository{
    var  listFilm = ArrayList<Film>()

    fun initializeComponents(){
        listFilm = ArrayList<Film>()
        val film= Film()
        film.annne=2017
        film.name="The Captain"
        film.type="Science Fic"
        film.budget="$0.11 M"
        film.description = "In the last moments of World War II, a young German soldier fighting for survival finds a Nazi captain's uniform."
        listFilm.add(film)

        val film1= Film()
        film1.annne=2013
        film1.name="The Wolf of Wall Street"
        film1.type="Science Fic"
        film1.budget="$116.90M"
        film1.description = "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government."
        listFilm.add(film1)

        val film2= Film()
        film2.annne=2012
        film2.name="Disconnect"
        film2.type="Science Fic"
        film2.budget="$7.44M"
        film2.description = "A drama centered on a group of people searching for human connections in today's wired world."
        listFilm.add(film2)

        val film3= Film()
        film3.annne=2015
        film3.name="Black"
        film3.type="Science Fic"
        film3.budget="$110.90M"
        film3.description = "When Mavela, member of the notorious youth gang Black Bronx, falls madly in love with a boy from a rival gang,"
        listFilm.add(film3)

        val film4= Film()
        film4.annne=2015
        film4.name="Beasts of No Nation "
        film4.type="Science Fic"
        film4.budget="$0.08M"
        film4.description = "A drama based on the experiences of Agu, a child soldier fighting in the civil war of an unnamed African country."
        listFilm.add(film4)
    }

    fun listFilms(filmRequest: FilmRequest):FilmResponse{
        initializeComponents()
        val filmResponse = FilmResponse()
        val listFilm1= listFilm.filter { film -> film.annne==filmRequest.annne  }
        filmResponse.films.addAll(listFilm1)
        listFilm.forEach { film -> if (film.annne==filmRequest.annne) println(film.name) }
        return filmResponse
    }

}