package no.training.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
public record Description (
    @JsonProperty("disclaimer_en")
    String disclaimerEn,
    @JsonProperty("disclaimer_es")
    String getDisclaimerEs,
    @JsonProperty("sol_desc_en")
    String sol_desc_En,
    @JsonProperty("sol_desc_es")
    String getSol_desc_Es,
    @JsonProperty("terrestrial_date_desc_en")
    String terrestrial_date_desc_En,
    @JsonProperty("terrestrial_date_desc_es")
    String getTerrestrial_date_desc_Es,
    @JsonProperty("temp_desc_en")
    String temp_desc_En,
    @JsonProperty("temp_desc_es")
    String temp_desc_Es,
    @JsonProperty("pressure_desc_en")
    String pressure_desc_En,
    @JsonProperty("pressure_desc_es")
    String pressure_desc_Es,
    @JsonProperty("abs_humidity_desc_en")
    String abs_humidity_desc_En,
    @JsonProperty("abs_humidity_desc_es")
    String abs_humidity_desc_Es,
    @JsonProperty("wind_desc_en")
    String wind_desc_En,
    @JsonProperty("wind_desc_es")
    String wind_desc_Es,
    @JsonProperty("gts_temp_desc_en")
    String gts_temp_desc_En,
    @JsonProperty("gts_temp_desc_es")
    String gts_temp_desc_Es,
    @JsonProperty("local_uv_irradiance_index_desc_en")
    String local_uv_irradiance_index_desc_En,
    @JsonProperty("local_uv_irradiance_index_desc_es")
    String local_uv_irradiance_index_desc_Es,
    @JsonProperty("atmo_opacity_desc_en")
    String atmo_opacity_desc_En,
    @JsonProperty("atmo_opacity_desc_es")
    String atmo_opacity_desc_Es,
    @JsonProperty("ls_desc_en")
    String ls_desc_En,
    @JsonProperty("ls_desc_es")
    String ls_desc_Es,
    @JsonProperty("season_desc_en")
    String season_desc_En,
    @JsonProperty("season_desc_es")
    String season_desc_Es,
    @JsonProperty("sunrise_sunset_desc_en")
    String sunrise_sunset_desc_En,
    @JsonProperty("sunrise_sunset_desc_es")
    String sunrise_sunset_desc_Es){
}
