package cn.chenhaonee.movies.service;

import cn.chenhaonee.movies.dao.NuomiDao;
import cn.chenhaonee.movies.domian.CinemaDetail;
import cn.chenhaonee.movies.domian.CinemaMovieItem;
import cn.chenhaonee.movies.domian.Cinemas;
import cn.chenhaonee.movies.domian.CityArea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhaonee on 2017/6/12.
 */
@Service
public class CinemaService {


    @Autowired
    private NuomiDao nuomiDao;

    public List<CityArea> getAreaList(String movieId) {
        return nuomiDao.getAreaList(movieId);
    }

    public List<Cinemas> getCinemaList(String movieId, String pageSize, String pageNum, String date, String areaId) {
        return nuomiDao.getCinemaList(movieId, pageSize, pageNum, date, areaId);
    }

    public List<CinemaMovieItem> getMovieItemList(String movieId, String date, String cinemaId) {
        return nuomiDao.getMovieItemList(movieId, date, cinemaId);
    }

    public List<CinemaDetail> getInfoList(String cinemaId) {
        return nuomiDao.getInfoList(cinemaId);
    }
}
