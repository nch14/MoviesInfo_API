package cn.chenhaonee.movies.controller;

import cn.chenhaonee.movies.domian.CinemaMovieItem;
import cn.chenhaonee.movies.domian.Cinemas;
import cn.chenhaonee.movies.vo.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @RequestMapping(value = "/nextWeek",method = RequestMethod.GET)
    @ApiOperation(value = "获得接下来七天的日期",notes = "")
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

    @RequestMapping(value = "/areaList",method = RequestMethod.GET)
    @ApiOperation(value = "获得区域列表",notes = "")
    public ResponseData<List<String>> getAreaList() {
        //stub
        List<String> areas = new ArrayList<>();
        areas.add("浦口区");
        areas.add("鼓楼区");
        areas.add("马群");
        return new ResponseData<>(areas);
    }

    @RequestMapping(value = "/cinemaList",method = RequestMethod.GET)
    @ApiOperation(value = "获得指定影片影院列表",notes = "date以及area请按照服务端返回的值作为参数进行请求")
    public ResponseData<List<Cinemas>> getCinemaList(@RequestParam(value = "movieId")String movieId,
                                                     @RequestParam(value = "date")String date,
                                                     @RequestParam(value = "area")String area) {
        //stub
        List<Cinemas> cinemas = new ArrayList<>();
        cinemas.add(new Cinemas("1","荣耀影院","召唤师峡谷002号","18388633386","70"));
        cinemas.add(new Cinemas("2","联盟影院","召唤师峡谷001号","18388633386","70"));
        return new ResponseData<>(cinemas);
    }

    @RequestMapping(value = "/cinemaItemList",method = RequestMethod.GET)
    @ApiOperation(value = "获得指定日期电影安排列表",notes = "date以及area请按照服务端返回的值作为参数进行请求")
    public ResponseData<List<CinemaMovieItem>> getMovieItemList(@RequestParam(value = "movieId")String movieId,
                                                     @RequestParam(value = "date")String date,
                                                     @RequestParam(value = "area")String area) {
        //stub
        List<CinemaMovieItem> cinemas = new ArrayList<>();
        cinemas.add(new CinemaMovieItem("20:15","22:10","英语","南大软院厅","80%可预定","￥28.8","￥28.8","￥48.8"));
        cinemas.add(new CinemaMovieItem("23:15","24:00","英语","南大计院厅","60%可预定","￥28.8","￥28.8","￥48.8"));
        return new ResponseData<>(cinemas);
    }
}
