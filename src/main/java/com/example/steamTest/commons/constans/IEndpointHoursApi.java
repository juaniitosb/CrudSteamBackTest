package com.example.steamTest.commons.constans;

public interface IEndpointHoursApi {
    String BASE_URL = "/hour/api";

    String CREATE_HOURS = "/createHours";

    String GET_HOURS_INFO = "/getHours/{idHour}";

    String GET_HOURS = "/getHours";

    String UPDATE_HOURS = "/updateHours";

    String DELETE_HOURS = "/deleteHours/{id_hour}";
}
