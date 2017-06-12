package cn.chenhaonee.movies.controller;

import cn.chenhaonee.movies.domian.Movies;
import cn.chenhaonee.movies.domian.MoviesShorcut;
import cn.chenhaonee.movies.service.MovieService;
import cn.chenhaonee.movies.vo.ResponseData;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhaonee on 2017/6/9.
 */
@CrossOrigin
@Api(value = "电影信息", description = "")
@RequestMapping(value = "/movie")
@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseData<List<MoviesShorcut>> getAllRecentMovies() {
        List<MoviesShorcut> list = movieService.getAllRecentMovies();
        return new ResponseData<>(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseData<Movies> getMovieInfo(@PathVariable(value = "id") String id) {
        Movies movies = movieService.getMovieDetails(id);
        return new ResponseData<>(movies);
    }

}
