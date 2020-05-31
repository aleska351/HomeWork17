import com.google.gson.Gson;

import java.util.*;

public class CallLog {

    public String remotePhoneNumber;
    public int duration;
    public Date startDate;

    public CallLog() {

        long date = (long) (Math.random()*(1586891297000l - 1262304000000l) + 1 ) +1262304000000l;
        List<String> remotePhoneNumbers = Arrays.asList("111", "112", "113", "114", "115", "116", "117", "118", "119");
        this.remotePhoneNumber = remotePhoneNumbers.get((int) (Math.random() * remotePhoneNumbers.size()));
        this.duration = (int) (Math.random() * 1000 - 1);
        this.startDate = new Date(date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CallLog)) return false;
        CallLog callLog = (CallLog) o;
        return duration == callLog.duration &&
                Objects.equals(remotePhoneNumber, callLog.remotePhoneNumber) &&
                Objects.equals(startDate, callLog.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(remotePhoneNumber, duration, startDate);
    }

    @Override
    public String toString() {
        return "CallLog{" +
                "remotePhoneNumber='" + remotePhoneNumber + '\'' +
                ", duration=" + duration +
                ", startDate=" + startDate +
                '}';
    }

    public static String callLogToJson(CallLog callLog) {
        Gson gson = new Gson();
        String json = gson.toJson(callLog);
        return json;
    }
    public static CallLog jsonToCallLog(String json) {
        Gson gson = new Gson();
        CallLog callLog = gson.fromJson(json, CallLog.class);
        return callLog;
    }
}