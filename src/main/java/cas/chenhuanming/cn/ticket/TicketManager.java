package cas.chenhuanming.cn.ticket;

import java.util.Optional;

/**
 * Created by Administrator on 2017-05-12.
 */
public interface TicketManager {
    Optional<Ticket> getTicket(String id);

    void addTicket(Ticket ticket);

}
