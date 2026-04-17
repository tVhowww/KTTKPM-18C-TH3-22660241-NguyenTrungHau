package edu.fit.iuh.movie_service.service;

import edu.fit.iuh.movie_service.entity.Movie;
import edu.fit.iuh.movie_service.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // Lấy toàn bộ danh sách phim
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Thêm một phim mới
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Lấy 1 phim
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
}