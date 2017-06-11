package cn.chenhaonee.movies.controller;

import cn.chenhaonee.movies.domian.Movies;
import cn.chenhaonee.movies.domian.MoviesShorcut;
import cn.chenhaonee.movies.vo.ResponseData;
import io.swagger.annotations.Api;
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

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ResponseData<List<MoviesShorcut>> getAllRecentMovies() {
        //stub
        List<MoviesShorcut> list = new ArrayList<>();
        list.add(new MoviesShorcut("新木乃伊", "6", "7", "8", "https://gss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/movie/pic/item/a5c27d1ed21b0ef4c3ff5f50d7c451da81cb3ead.jpg", "1"));
        list.add(new MoviesShorcut("神奇女侠", "6", "7", "8", "https://gss0.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/movie/pic/item/8d5494eef01f3a29544ff3a99325bc315d607cd5.jpg", "2"));
        return new ResponseData<>(list);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseData<Movies> getMovieInfo(@PathVariable(value = "id") String id) {
        //stub
        if (id == "1") {
            return new ResponseData<>(new Movies("1",
                    "新木乃伊",
                    "7",
                    "8",
                    "9",
                    "正义从她开始",
                    "派蒂·杰金斯",
                    "盖尔·加朵,克里斯·派恩,罗宾·怀特,丹尼·休斯顿,大卫·休里斯,康妮·尼尔森,埃琳纳·安娜亚,艾文·布莱纳,露茜·戴维斯,萨伊德·塔格马奥,尤金·布雷·洛克,Dino Fazzani,Miroslav Zaruba,马科·莱特,Roman Green",
                    "美国",
                    "142分钟",
                    "2017-06-02上映",
                    "亚马逊公主戴安娜·普林斯（盖尔·加朵 Gal Gadot 饰），经过在家乡天堂岛的训练，取得上帝赐予的武器 与装备，化身神奇女侠，与空军上尉史蒂夫·特雷弗（克里斯·派恩 Chris Pine 饰）一同来到人类世界，一起捍卫和平、拯救世界，在一战期间上演了震撼人心的史诗传奇。"));
        } else {
            return new ResponseData<>(new Movies("2",
                    "神奇女侠",
                    "7",
                    "8",
                    "9",
                    "正义从她开始",
                    "派蒂·杰金斯",
                    "盖尔·加朵,克里斯·派恩,罗宾·怀特,丹尼·休斯顿,大卫·休里斯,康妮·尼尔森,埃琳纳·安娜亚,艾文·布莱纳,露茜·戴维斯,萨伊德·塔格马奥,尤金·布雷·洛克,Dino Fazzani,Miroslav Zaruba,马科·莱特,Roman Green",
                    "美国",
                    "142分钟",
                    "2017-06-02上映",
                    "亚马逊公主戴安娜·普林斯（盖尔·加朵 Gal Gadot 饰），经过在家乡天堂岛的训练，取得上帝赐予的武器 与装备，化身神奇女侠，与空军上尉史蒂夫·特雷弗（克里斯·派恩 Chris Pine 饰）一同来到人类世界，一起捍卫和平、拯救世界，在一战期间上演了震撼人心的史诗传奇。"));
        }
    }

}
