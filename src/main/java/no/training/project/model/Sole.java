package no.training.project.model;

public class MartianWeatherModelClass {
    private int id;
    private String terrestrial_date;
    private String sol;
    private String ls;
    private String season;
    private String min_temp;
    private String max_temp;
    private String pressure;
    private String pressure_string;
    private String abs_humidity;
    private String wind_speed;
    private String wind_direction;
    private String atmo_opacity;
    private String sunrise;
    private String sunset;
    private String local_uv_irradiance_index;
    private String min_gts_temp;
    private String max_gts_temp;

    public MartianWeatherModelClass(int id, String terrestrial_date, String sol, String ls, String season, String min_temp, String max_temp, String pressure, String pressure_string, String abs_humidity, String wind_speed, String wind_direction, String atmo_opacity, String sunrise, String sunset, String local_uv_irradiance_index, String min_gts_temp, String max_gts_temp) {
        this.id = id;
        this.terrestrial_date = terrestrial_date;
        this.sol = sol;
        this.ls = ls;
        this.season = season;
        this.min_temp = min_temp;
        this.max_temp = max_temp;
        this.pressure = pressure;
        this.pressure_string = pressure_string;
        this.abs_humidity = abs_humidity;
        this.wind_speed = wind_speed;
        this.wind_direction = wind_direction;
        this.atmo_opacity = atmo_opacity;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.local_uv_irradiance_index = local_uv_irradiance_index;
        this.min_gts_temp = min_gts_temp;
        this.max_gts_temp = max_gts_temp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerrestrial_date() {
        return terrestrial_date;
    }

    public void setTerrestrial_date(String terrestrial_date) {
        this.terrestrial_date = terrestrial_date;
    }

    public String getSol() {
        return sol;
    }

    public void setSol(String sol) {
        this.sol = sol;
    }

    public String getLs() {
        return ls;
    }

    public void setLs(String ls) {
        this.ls = ls;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(String min_temp) {
        this.min_temp = min_temp;
    }

    public String getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(String max_temp) {
        this.max_temp = max_temp;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getPressure_string() {
        return pressure_string;
    }

    public void setPressure_string(String pressure_string) {
        this.pressure_string = pressure_string;
    }

    public String getAbs_humidity() {
        return abs_humidity;
    }

    public void setAbs_humidity(String abs_humidity) {
        this.abs_humidity = abs_humidity;
    }

    public String getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(String wind_speed) {
        this.wind_speed = wind_speed;
    }

    public String getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(String wind_direction) {
        this.wind_direction = wind_direction;
    }

    public String getAtmo_opacity() {
        return atmo_opacity;
    }

    public void setAtmo_opacity(String atmo_opacity) {
        this.atmo_opacity = atmo_opacity;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getLocal_uv_irradiance_index() {
        return local_uv_irradiance_index;
    }

    public void setLocal_uv_irradiance_index(String local_uv_irradiance_index) {
        this.local_uv_irradiance_index = local_uv_irradiance_index;
    }

    public String getMin_gts_temp() {
        return min_gts_temp;
    }

    public void setMin_gts_temp(String min_gts_temp) {
        this.min_gts_temp = min_gts_temp;
    }

    public String getMax_gts_temp() {
        return max_gts_temp;
    }

    public void setMax_gts_temp(String max_gts_temp) {
        this.max_gts_temp = max_gts_temp;
    }

    @Override
    public String toString() {
        return "MartianWeather{" +
                "id=" + id +
                ", terrestrial_date='" + terrestrial_date + '\'' +
                ", sol='" + sol + '\'' +
                ", ls='" + ls + '\'' +
                ", season='" + season + '\'' +
                ", min_temp='" + min_temp + '\'' +
                ", max_temp='" + max_temp + '\'' +
                ", pressure='" + pressure + '\'' +
                ", pressure_string='" + pressure_string + '\'' +
                ", abs_humidity='" + abs_humidity + '\'' +
                ", wind_speed='" + wind_speed + '\'' +
                ", wind_direction='" + wind_direction + '\'' +
                ", atmo_opacity='" + atmo_opacity + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                ", local_uv_irradiance_index='" + local_uv_irradiance_index + '\'' +
                ", min_gts_temp='" + min_gts_temp + '\'' +
                ", max_gts_temp='" + max_gts_temp + '\'' +
                '}';
    }
}
