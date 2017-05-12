package cas.chenhuanming.cn.ticket;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by Administrator on 2017-05-12.
 */
public class TicketManager implements TicketAccess{
    private final ConcurrentHashMap<String,Ticket> tickets;
    private final Optional emptyTicket = Optional.empty();

    public TicketManager() {
        tickets = new ConcurrentHashMap<>();
    }

    @Override
    public Optional<Ticket> getTicket(String id) {
        Ticket ticket = tickets.get(id);
        if(ticket==null)
            return emptyTicket;
        else
            return Optional.of(ticket);
    }

    @Override
    public void addTicket(Ticket ticket) {
        tickets.put(ticket.getId(),ticket);
    }
}
