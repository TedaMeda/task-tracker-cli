package command;

import util.StringUtils;

import java.util.List;

public class CommandLineParser {
    private final String s;

    public CommandLineParser(String s) {
        this.s = s;
    }

    public List<String> getArgs(){
        return StringUtils.parseString(s);
    }
}
