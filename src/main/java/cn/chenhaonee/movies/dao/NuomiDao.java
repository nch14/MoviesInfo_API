package cn.chenhaonee.movies.dao;

import cn.chenhaonee.movies.domian.*;
import cn.chenhaonee.movies.vo.ResponseData;
import io.swagger.annotations.ApiOperation;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by chenhaonee on 2017/6/12.
 */
@Service
public class NuomiDao {

    @Value("${server.nuomi.url}")
    private String url;

    private static OkHttpClient client = new OkHttpClient();

    public List<MoviesShorcut> getAllRecentMovies() {
        String url = this.url + "/movie/all";
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String content = response.body().string();
                JSONObject data = new JSONObject(content);
                JSONArray list = data.getJSONArray("data");
                List<MoviesShorcut> movies = list.toList().stream().map(this::parseMovieSnap).filter(shortCut -> shortCut != null).collect(Collectors.toList());
                return movies;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Movies getMovieDetail(String id) {
        String url = this.url + "/movie/" + id;
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String content = response.body().string();
                JSONObject data = new JSONObject(content);
                JSONObject detail = data.getJSONObject("data");
                return parseMovieDetail(detail);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //http://localhost:8880/cinema/areaList?movieId=63068
    public List<CityArea> getAreaList(String movieId) {
        String url = this.url + "/cinema/areaList?movieId=" + movieId;
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String content = response.body().string();
                JSONObject data = new JSONObject(content);
                JSONArray list = data.getJSONArray("data");
                List<CityArea> cityAreas = list.toList().stream().map(this::parseCityArea).filter(shortCut -> shortCut != null).collect(Collectors.toList());
                return cityAreas;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Cinemas> getCinemaList(String movieId, String date, String area) {
        String url = this.url + "/cinema/cinemaList?movieId=" + movieId + "&date=" + date + "&cityId=" + 315 + "&areaId=" + area;
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String content = response.body().string();
                JSONObject data = new JSONObject(content);
                JSONArray list = data.getJSONArray("data");
                List<Cinemas> cinemas = list.toList().stream().map(this::parseCinemas).filter(shortCut -> shortCut != null).collect(Collectors.toList());
                return cinemas;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CinemaMovieItem> getMovieItemList(String movieId, String date, String cinemaId) {
        String url = this.url + "/cinema/cinemaItemList?movieId=" + movieId + "&date=" + date + "&cinemaId=" + cinemaId;
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String content = response.body().string();
                JSONObject data = new JSONObject(content);
                JSONArray list = data.getJSONObject("data").getJSONArray("schedules");
                List<CinemaMovieItem> schedules = list.toList().stream().map(this::parseSchedule).filter(shortCut -> shortCut != null).collect(Collectors.toList());
                return schedules;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CinemaDetail> getInfoList(String cinemaId) {
        //http://localhost:8880/cinema/cinemaInfo?cinemaId=804

        String url = this.url + "/cinema/cinemaInfo?cinemaId=" + cinemaId;
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String content = response.body().string();
                JSONObject data = new JSONObject(content);
                JSONArray list = data.getJSONArray("data");
                List<CinemaDetail> schedules = list.toList().stream().map(this::parseCinemaDetail).filter(shortCut -> shortCut != null).collect(Collectors.toList());
                return schedules;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private MoviesShorcut parseMovieSnap(Object o) {
        MoviesShorcut shorcut;
        if (o instanceof Map) {
            Map item = (Map) o;
            int movieId = (int) item.get("movieId");
            String name = (String) item.get("name");
            String mark = (String) item.get("mark");
            String imgUrl = (String) item.get("imgUrl");
            shorcut = new MoviesShorcut(name, mark, null, null, imgUrl, "" + movieId);
            return shorcut;
        }
        return null;
    }

    private Movies parseMovieDetail(Object o) {
        if (o instanceof JSONObject) {
            JSONObject item = (JSONObject) o;
            String name = item.getString("name");
            String marks = item.getString("marks");
            String des = item.getString("des");
            String director = item.getString("director");
            String roles = item.getString("roles");
            String country = item.getString("country");
            String length = item.getString("length");
            String time = item.getString("time");
            String content = item.getString("content");
            Movies movies = new Movies(null, name, marks, null, null, des, director, roles, country, length, time, content,"");
            return movies;
        }
        return null;
    }

    private CityArea parseCityArea(Object o) {
        if (o instanceof Map) {
            Map item = (Map) o;
            String id = (String) item.get("id");
            String name = (String) item.get("name");
            CityArea cityArea = new CityArea(id, name);
            return cityArea;
        }
        return null;
    }

    private Cinemas parseCinemas(Object o) {
        if (o instanceof Map) {
            Map item = (Map) o;
            String cinemaId = (String) item.get("cinemaId");
            String name = (String) item.get("name");
            String price = (String) item.get("price");
            String address = (String) item.get("address");

            Cinemas cinemas = new Cinemas(cinemaId, name, address, price);
            return cinemas;
        }
        return null;
    }

    private CinemaMovieItem parseSchedule(Object o) {
        Map item = (Map) o;
        int remainedSeatNumber = (int) item.get("remainedSeatNumber");
        int totalSeatNumber = (int) item.get("totalSeatNumber");
        int remainedSeatRate = (int) item.get("remainedSeatRate");
        double rate = ((double) remainedSeatRate) / 100;

        String language = (String) item.get("language");

        int price = (int) item.get("price");
        int memCardPrice = (int) item.get("memCardPrice");
        int originalPrice = (int) item.get("originalPrice");

        long startTime = (long) item.get("startTime");
        long endTime = (long) item.get("endTime");
        String theaterName = (String) item.get("theaterName");

        String version = (String) item.get("version");
//String startAt, String endAt, String language, String roomName, String seatsNow, String priceInNuomi, String priceInMaoyan, String priceInTaopiaopiao

        SimpleDateFormat sdf = new SimpleDateFormat("mm-DD HH:mm");
        String startAt = sdf.format(new Date(startTime));
        String endAt = sdf.format(new Date(endTime));

        CinemaMovieItem cinemaMovieItem = new CinemaMovieItem(startAt, endAt, language, theaterName, "" + rate,totalSeatNumber,remainedSeatNumber,version, "" + price, "" + originalPrice, null, null, null, null);
        return cinemaMovieItem;
    }

    private CinemaDetail parseCinemaDetail(Object o) {
        if (o instanceof Map) {
            Map item = (Map) o;
            String key = (String) item.get("key");
            String value = (String) item.get("value");
            CinemaDetail cinemas = new CinemaDetail(key, value);
            return cinemas;
        }
        return null;
    }
}
