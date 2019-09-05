package com.example.finalevent;

import android.provider.BaseColumns;

public final class EventMaster {
    private EventMaster(){}

        public static class Events implements BaseColumns {

            public static final String TABLE_NAME = "events";
            public static final String ID_S = "id";
            public static final String COL_1_S = "date";
            public static final String COL_2_S = "time";
            public static final String COL_3_S = "place";
            public static final String COL_4_S = "guests";
            public static final String COL_5_S= "budget";
            public static final String COL_6_S = "theme";
            public static final String COL_7_S= "photo";
            public static final String COL_8_S= "food";
            public static final String COL_9_S = "enter";
        }
}
