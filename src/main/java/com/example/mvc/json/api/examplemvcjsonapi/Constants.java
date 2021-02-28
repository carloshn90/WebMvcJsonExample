package com.example.mvc.json.api.examplemvcjsonapi;

public final class Constants {

    private Constants() {
        throw new IllegalAccessError("Constant class");
    }

    public static final class JWT {

        private JWT() {
            throw new IllegalAccessError("Constant class");
        }

        public static final String TOKEN_HEADER = "Authorization";
        public static final String TOKEN_PREFIX = "Bearer";
        public static final String USER_NAME = "username";
    }
}
