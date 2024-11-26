package task;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaskModelMapper {
    public static Map<String, Object> toMap(Task task){
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", task.getId());
        map.put("name", task.getName());
        map.put("status", task.getStatus().getS());
        map.put("createdAt", task.getCreatedDate());
        map.put("updatedAt", task.getUpdatedDate());
        return map;
    }
    public static Task toTask(Map<String, Object> map){
        Task task = new Task();
        task.setId(Integer.parseInt((String) map.get("id")));
        task.setName((String) map.get("name"));
        task.setStatus(TaskStatus.getValueOf((String) map.get("status")));
        task.setCreatedDate(LocalDateTime.parse((CharSequence) map.get("createdAt")));
        task.setUpdatedDate(LocalDateTime.parse((CharSequence) map.get("updatedAt")));
        return task;
    }
}
