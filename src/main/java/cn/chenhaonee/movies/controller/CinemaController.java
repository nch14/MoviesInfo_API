package cn.chenhaonee.movies.controller;

import cn.chenhaonee.movies.domian.CinemaDetail;
import cn.chenhaonee.movies.domian.CinemaMovieItem;
import cn.chenhaonee.movies.domian.Cinemas;
import cn.chenhaonee.movies.domian.CityArea;
import cn.chenhaonee.movies.service.CinemaService;
import cn.chenhaonee.movies.service.DateCode;
import cn.chenhaonee.movies.vo.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by chenhaonee on 2017/6/9.
 */
@CrossOrigin
@Api(value = "影院信息", description = "")
@RequestMapping(value = "/cinema")
@RestController
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @RequestMapping(value = "/nextWeek", method = RequestMethod.GET)
    @ApiOperation(value = "获得接下来七天的日期", notes = "")
    public ResponseData<List<String>> getNextWeek() {
        LocalDate today = LocalDate.now();
        List<String> days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            String dateInString = today.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"));
            dateInString = dateInString.substring(5);
            String weekDay = today.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.CHINESE);
            weekDay = weekDay.replace("星期", "周");
            days.add(dateInString + "（" + weekDay + "）");
            today = today.plusDays(1);
        }
        String todayInString = days.remove(0);
        todayInString = todayInString.substring(0, 6) + "（今天）";
        days.add(0, todayInString);
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
                                                     @RequestParam(value = "pageSize", required = false, defaultValue = "6") String pageSize,
                                                     @RequestParam(value = "pageNum", required = false, defaultValue = "0") String pageNum,
                                                     @RequestParam(value = "areaId") String areaId) {
        String dateDecoded = DateCode.toMyDate(date);
        List<Cinemas> cinemas = cinemaService.getCinemaList(movieId, pageSize, pageNum, dateDecoded, areaId);
        return new ResponseData<>(cinemas);
    }

    @RequestMapping(value = "/cinemaItemList", method = RequestMethod.GET)
    @ApiOperation(value = "获得指定日期电影安排列表", notes = "date以及area请按照服务端返回的值作为参数进行请求")
    public ResponseData<List<CinemaMovieItem>> getMovieItemList(@RequestParam(value = "movieId") String movieId,
                                                                @RequestParam(value = "date") String date,
                                                                @RequestParam(value = "cinemaId") String cinemaId) {
        String dateDecoded = DateCode.toMyDate(date);
        List<CinemaMovieItem> cinemas = cinemaService.getMovieItemList(movieId, dateDecoded, cinemaId);
        return new ResponseData<>(cinemas);
    }

    @RequestMapping(value = "/cinemaInfo", method = RequestMethod.GET)
    @ApiOperation(value = "获得电影院详细", notes = "")
    public ResponseData<List<CinemaDetail>> getInfoList(@RequestParam(value = "cinemaId") String cinemaId) {
        List<CinemaDetail> cinemaDetails = cinemaService.getInfoList(cinemaId);
        return new ResponseData<>(cinemaDetails);
    }
}
