package no.training.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
public record Sole(

        String id,
        @JsonProperty("terrestrial_date")
        String terrestrialDate,
        String sol,
        String ls,
        String season,
        @JsonProperty("min_temp")
        String minTemp,
        @JsonProperty("max_temp")
        String maxTemp,
        String pressure,
        @JsonProperty("pressure_string")
        String pressureString,
        @JsonProperty("abs_humidity")
                String absHumidity,
        @JsonProperty("wind_speed")
        String windSpeed,
        @JsonProperty("wind_direction")
        String windDirection,
        @JsonProperty("atmo_opacity")
        String atmoOpacity,
        String sunrise,
        String sunset,
        @JsonProperty("local_uv_irradiance_index")
        String localUvIrradianceIndex,
        @JsonProperty("min_gts_temp")
        String minGtsTemp,
        @JsonProperty("max_gts_temp")
        String maxGtsTemp){
}
