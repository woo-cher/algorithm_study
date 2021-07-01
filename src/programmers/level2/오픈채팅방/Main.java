package programmers.level2.오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
    }

    public static String[] solution(String[] record) {
        Map<String, String> users = new HashMap<>();
        List<OpenChatLog> logs = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        ActionType type;

        for (String tuple : record) {
            String[] data = tuple.split(" ");
            String action = data[0];
            String uuid = data[1];
            String nickName = data.length > 2 ? data[2] : "";

            switch (action) {
                case "Enter":
                    if (users.containsKey(uuid)) {
                        users.replace(uuid, nickName);
                    } else {
                        users.put(uuid, nickName);
                    }

                    type = ActionType.valueOf(action);
                    logs.add(new OpenChatLog(uuid, type));
                    break;

                case "Leave":
                    type = ActionType.valueOf(action);
                    logs.add(new OpenChatLog(uuid, type));
                    break;

                case "Change":
                    users.replace(uuid, nickName);
                    break;
            }
        }

        for (OpenChatLog log : logs) {
            answer.add(users.get(log.getUuid()) + "님이 " + log.getActionType().getAction());
        }

        return answer.toArray(String[]::new);
    }
}

class OpenChatLog {
    private String uuid;
    private ActionType action;

    OpenChatLog() {}

    public OpenChatLog(String uuid, ActionType action) {
        this.uuid = uuid;
        this.action = action;
    }

    public String getUuid() {
        return this.uuid;
    }

    public ActionType getActionType() {
        return this.action;
    }
}

enum ActionType {
    UNKNOWN("정보없음."),

    Enter("들어왔습니다."),
    Leave("나갔습니다.");

    private String action;

    ActionType(String action) {
        this.action = action;
    }

    public String getCode() {
        return name();
    }

    public String getAction() {
        return action;
    }
}
