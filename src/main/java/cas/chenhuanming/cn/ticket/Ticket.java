package cas.chenhuanming.cn.ticket;

import java.time.LocalDateTime;

/**
 * Created by Administrator on 2017-05-12.
 */
public class Ticket {
    private final String id;
    private final String username;
    private final LocalDateTime birthTime;
    private LocalDateTime deadline;

    public Ticket(String id, String username, LocalDateTime birthTime, LocalDateTime deadline) {
        this.id = id;
        this.username = username;
        this.birthTime = birthTime;
        this.deadline = deadline;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public LocalDateTime getBirthTime() {
        return birthTime;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }
}
