package cn.chenhaonee.movies.controller;

import cn.chenhaonee.movies.domian.CinemaDetail;
import cn.chenhaonee.movies.domian.CinemaMovieItem;
import cn.chenhaonee.movies.domian.Cinemas;
import cn.chenhaonee.movies.domian.CityArea;
import cn.chenhaonee.movies.service.CinemaService;
import cn.chenhaonee.movies.vo.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhaonee on 2017/6/9.
 */
@CrossOrigin
@Api(value = "影院信息", description = "")
@RequestMapping(value = "/cinema")
@RestController
public class CinameController {

    @Autowired
    private CinemaService cinemaService;

    @RequestMapping(value = "/nextWeek", method = RequestMethod.GET)
    @ApiOperation(value = "获得接下来七天的日期", notes = "")
    public ResponseData<List<String>> getNextWeek() {
        LocalDate today = LocalDate.now();
        List<String> days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            String dateInString = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            days.add(dateInString);
            today = today.plusDays(1);
        }
        return new ResponseData<>(days);
    }

    @RequestMapping(value = "/areaList", method = RequestMethod.GET)
    @ApiOperation(value = "获得区域列表", notes = "")
    public ResponseData<List<CityArea>> getAreaList(@RequestParam(value = "movieId") String movieId) {
        //stub
        List<CityArea> areas = cinemaService.getAreaList(movieId);
        return new ResponseData<>(areas);
    }

    @RequestMapping(value = "/cinemaList", method = RequestMethod.GET)
    @ApiOperation(value = "获得指定影片影院列表", notes = "date以及area请按照服务端返回的值作为参数进行请求")
    public ResponseData<List<Cinemas>> getCinemaList(@RequestParam(value = "movieId") String movieId,
                                                     @RequestParam(value = "date") String date,
                                                     @RequestParam(value = "areaId") String areaId) {
        List<Cinemas> cinemas = cinemaService.getCinemaList(movieId, date, areaId);
        return new ResponseData<>(cinemas);
    }

    @RequestMapping(value = "/cinemaItemList", method = RequestMethod.GET)
    @ApiOperation(value = "获得指定日期电影安排列表", notes = "date以及area请按照服务端返回的值作为参数进行请求")
    public ResponseData<List<CinemaMovieItem>> getMovieItemList(@RequestParam(value = "movieId") String movieId,
                                                                @RequestParam(value = "date") String date,
                                                                @RequestParam(value = "cinemaId") String cinemaId) {
        List<CinemaMovieItem> cinemas = cinemaService.getMovieItemList(movieId, date, cinemaId);
        return new ResponseData<>(cinemas);
    }

    @RequestMapping(value = "/cinemaInfo", method = RequestMethod.GET)
    @ApiOperation(value = "获得电影院详细", notes = "")
    public ResponseData<List<CinemaDetail>> getInfoList(@RequestParam(value = "cinemaId") String cinemaId) {
        List<CinemaDetail> cinemaDetails = cinemaService.getInfoList(cinemaId);
        return new ResponseData<>(cinemaDetails);
    }
}
