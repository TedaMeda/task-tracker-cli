package json;

import task.Task;
import task.TaskModelMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JsonUtil {
    public static String toJsonArray(List<Task> mp) {
        StringBuilder jsonString = new StringBuilder("[");
        for (Task task : mp) {
            Map<String, Object> map = TaskModelMapper.toMap(task);
            jsonString.append('{');
            map.forEach((key, value) -> {
                jsonString.append("\"").append(key).append("\"");
                jsonString.append(':');
                if (value instanceof String || value instanceof LocalDateTime)
                    jsonString.append("\"").append(value).append("\"");
                else jsonString.append(value);
                jsonString.append(',');
            });
            jsonString.deleteCharAt(jsonString.length() - 1);
            jsonString.append('}');
            jsonString.append(',');
        }
        if(!mp.isEmpty()) jsonString.deleteCharAt(jsonString.length()-1);
        jsonString.append(']');
        return jsonString.toString();
    }

    public static List<Task> toTaskList(String json) {
        List<Task> tasks = new ArrayList<>();
        if (json != null && !json.trim().isEmpty()) {
            json = json.trim().substring(1, json.length() - 1);
            String[] items = json.replace(" {", "{").split("},\\{");
            for (String item : items) {
                Map<String, Object> map = new LinkedHashMap<>();
                item = item.replace("}", "").replace("{", "");
                String[] pairs = item.split(",");
                for (String pair : pairs) {
                    String[] keyValue = pair.split(":", 2);
                    if(keyValue.length<2)return tasks;
                    String key = keyValue[0].trim().replace("\"", "");
                    String value = keyValue[1].trim().replace("\"", "");
                    map.put(key, value);
                }
                tasks.add(TaskModelMapper.toTask(map));
            }
        }
        return tasks;
    }
}
