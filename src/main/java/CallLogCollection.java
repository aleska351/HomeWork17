import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CallLogCollection {
    public static void main(String[] args) {
        List<CallLog> callLogs = new ArrayList<>();

        System.out.println("Преобразуем и выводим коллекцию в JSON");
        String s = collectionToJson(addsElement(args));
        System.out.println(s);
        System.out.println("-----------------------------------------------------");
        System.out.println();
        System.out.println(" Преобразуем строку JSON обратно в коллекцию и выводим на экран");
        printCollection(jsonToCollection(s));
        System.out.println("----------------------------------------------------------");
        System.out.println("Создаем рандомно обьект CallLog и выводим его");
        CallLog callLog = new CallLog();
        System.out.println(callLog);
        System.out.println(" Преобразуем обьект CallLog в JSON");
        String call = CallLog.callLogToJson(callLog);
        System.out.println(call);
        System.out.println(" Преобразуем JSON обратно в обьект CallLog");
        CallLog anyCallLog = CallLog.jsonToCallLog(call);
        System.out.println(anyCallLog);
    }

    public static List<CallLog> addsElement(String[] args) {
        List<CallLog> callLogs = new ArrayList<>();
        if (args.length != 0) {
            int j = Integer.parseInt(args[0]);
            for (int i = 0; i < j; i++) {
                callLogs.add(new CallLog());
            }
            return callLogs;
//
        } else if (args.length == 0) {
            for (int i = 0; i < 10; i++) {
                callLogs.add(new CallLog());
            }
        }
        return callLogs;
    }

    public static void printCollection(Collection<CallLog> callLogs) {
        for (CallLog callLog : callLogs) {
            System.out.println(callLog);
        }
    }

    public static String collectionToJson(List<CallLog> callLogs) {
        Gson gson = new Gson();
        String json = gson.toJson(callLogs);
        return json;
    }

    public static List<CallLog> jsonToCollection(String json) {
        Gson gson = new Gson();
        Type collectionType = new TypeToken<Collection<CallLog>>() {
        }.getType();
        List<CallLog> calls = gson.fromJson(json, collectionType);
        return calls;
    }
}