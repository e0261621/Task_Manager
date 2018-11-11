package tic2002.misc;

import java.text.SimpleDateFormat;
import java.util.Date;

public class helper {
    public static String getDateInFileWriteFormat() {
        String pattern = "ddMMMyyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        return date;
    }
}
