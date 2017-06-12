package cn.chenhaonee.movies.service;

import cn.chenhaonee.movies.dao.NuomiDao;
import cn.chenhaonee.movies.domian.Movies;
import cn.chenhaonee.movies.domian.MoviesShorcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenhaonee on 2017/6/12.
 */
@Service
public class MovieService {

    @Autowired
    private NuomiDao nuomiDao;

    public List<MoviesShorcut> getAllRecentMovies() {
        return nuomiDao.getAllRecentMovies();
    }

    public Movies getMovieDetails(String movieId) {
        return nuomiDao.getMovieDetail(movieId);
    }
}
