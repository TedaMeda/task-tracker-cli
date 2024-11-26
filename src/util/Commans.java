package util;

import fileSystem.FileUtils;
import json.JsonUtil;

public class Commans {
    public static final String FILE_NAME = "db.json";
    public static Integer id = -1;
    public static Integer getId(){
        if(id==-1){
           id=JsonUtil.toTaskList(FileUtils.readFile(FILE_NAME)).size();
        }
        return id++;
    }
}
