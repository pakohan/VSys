package blatt4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class BullyProcess extends Process {
    private boolean isElected = true;
    private volatile UUID u;

    public BullyProcess(int id) {
        super(id);
    }

    @Override
    public void startElection() {
        Set<Map.Entry<Integer, Process>> s = super.destinations.entrySet();
        for (Map.Entry<Integer, Process> entry : s) {
            if (entry.getKey() > super.getID()) {
                u = new UUID(0L, Message.getLast_uuid());
                entry.getValue().receiveMessage(new Message(Message.MessageType.ELECT, super.getID(), u));
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            Message m = null;
            try {
                m = msgQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (m.getType() == Message.MessageType.ELECT && m.getSender() < super.getID() && u != null && !u.equals(m.getUuid())) {
                destinations.get(m.getSender()).receiveMessage(new Message(Message.MessageType.RESPONSE, super.getID(), m.getUuid()));
                u = m.getUuid();
            } else if (m.getType() == Message.MessageType.RESPONSE) {
                isElected = false;
            }

            System.out.println(isElected + " : " + super.getID());
        }
    }
}
