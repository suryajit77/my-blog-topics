package com.framework.data;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * All framework related constants which are not defined in application.properties.
 */
public class Constants {

    public static final String APP_URL = "https://opensource-demo.orangehrmlive.com/";
    public static final String API_URL = "https://reqres.in/";

    public static final String BLANK = "";
    public static final String LOCALHOST = "localhost";

    public static final LocalDate LOCAL_DATE_NOW = LocalDate.now();
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("ddLLLLyyyy");

    //Framework related directory paths
    public static final String PROJECT_ROOT_DIR = Paths.get(".").normalize().toAbsolutePath().toString();
    public static final String SCREENSHOTS_DIRECTORY = PROJECT_ROOT_DIR.concat("/screenshots/");
    public static final String PASSED_SCREENSHOTS_DIR_PATH = PROJECT_ROOT_DIR.concat("/screenshots/passed/");
    public static final String FAILED_SCREENSHOTS_DIR_PATH = PROJECT_ROOT_DIR.concat("/screenshots/failed/");
    public static final String DIFFERENCE_SCREENSHOTS_DIR_PATH = PROJECT_ROOT_DIR.concat("/screenshots/difference/");
    public static final String EXPECTED_SCREENSHOTS_DIR_PATH = PROJECT_ROOT_DIR.concat("/screenshots/expected/");
    public static final List<String> ALL_PROJECT_DIR_PATHS = List.of(SCREENSHOTS_DIRECTORY, PASSED_SCREENSHOTS_DIR_PATH,
            FAILED_SCREENSHOTS_DIR_PATH, EXPECTED_SCREENSHOTS_DIR_PATH, DIFFERENCE_SCREENSHOTS_DIR_PATH);

    //API Related Constants
    public static final String CONTENT_TYPE_JSON_CHARSET_UTF8 = "application/json;charset=utf-8";
    public static final String HEADER = "header";
    public static final String RESPONSE_HEADER = "responseHeader";
    public static final String MULTI_VALUE_HEADER = "multiValueHeader";
    public static final String X_API_KEY_HEADER = "X-Api-Key";
    public static final String X_MOCK_MATCH_REQUEST_HEADERS = "x-mock-match-request-headers";
    public static final String X_MOCK_MATCH_REQUEST_BODY = "x-mock-match-request-body";
    public static final String X_SRV_TRACE = "x-srv-trace";
    public static final String X_SRV_SPAN = "x-srv-span";
    public static final String X_RATE_LIMIT_LIMIT = "X-RateLimit-Limit";
    public static final String X_RATE_LIMIT_REMAINING = "X-RateLimit-Remaining";
    public static final String X_RATE_LIMIT_RESET = "X-RateLimit-Reset";

    public static final String CLIENT_ID = "client_id";
    public static final String CLIENT_SECRET = "client_secret";
    public static final String GRANT_TYPE = "grant_type";
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String ACCESS_TOKEN = "access_token";
    public static final String REDIRECT_URI = "redirect_uri";
    public static final String EXPIRY_TIME = "expires_in";
    public static final String API_KEY = "apiKey";
    public static final String PATH_PARAM = "path_param";

    //Common Regex Constants
    public static final String RFC5322_EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public static final String NAME_REGEX = "/^[a-z ,.'-]+$/i";
}
