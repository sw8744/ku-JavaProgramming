package week06.lsw;

import java.util.Arrays;

public class TicketManager {
    private String name;
    private final int NUMBER;
    private Ticket[] tickets;
    private int count = 0;

    public TicketManager(String name, int NUMBER) {
        this.name = name;
        this.NUMBER = NUMBER;
        if(this.NUMBER > 0) {
            tickets = new Ticket[NUMBER];
        }
    }

    public void register(Ticket ticket) {
        if(this.count < tickets.length) {
            tickets[count++] = ticket;
        }
        else {
            System.out.println("티켓 판매 완료");
        }
    }

    public double getTotal() {
        double total = 0;
        for(Ticket ticket : tickets) {
            if(ticket != null) {
                total += ticket.getPrice();
            }
            else {
                break;
            }
        }
        return total;
    }

    @Override
    public String toString() {
        String str = "공연명 : " + this.name + "\n";
        str += "좌석수 : " + this.NUMBER + "\n";
        str += "총 판매티켓 수 : " + this.count + "\n";
        str += "====================\n";
        for(Ticket ticket : tickets) {
            if(ticket != null) {
                str += ticket.toString();
                str += "\n-----------------\n";
            }
            else {
                break;
            }
        }
        str += "====================\n";
        str += "총 티켓 판매 금액 : " + this.getTotal() + "\n";
        return str;
    }

    public void showGeneralTicket(boolean payByCredit) {
        for(Ticket ticket : tickets) {
            if(ticket != null && ticket instanceof GeneralTicket t) {
//                GeneralTicket t = (GeneralTicket) ticket;
                if(t.isPayByCredit() == payByCredit) {
                    System.out.println(t);
                }
            }
        }
    }

    public void showAdvanceTicket(int advanceDays) {
        for(Ticket ticket : tickets) {
            if(ticket != null && ticket instanceof AdvanceTicket a) {
                if(a.getAdvanceDays() > advanceDays) {
                    System.out.println(a);
                }
            }
        }
    }
}
