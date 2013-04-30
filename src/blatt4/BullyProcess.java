package blatt4;

import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class BullyProcess extends Process {
    private volatile boolean isElectable = true;
    private volatile boolean iswaiting = false;
    private volatile UUID u;

    public BullyProcess(int id) {
        super(id);
    }

    @Override
    public void startElection() {
        UUID id = new UUID(0L, Message.getLast_uuid());
        sendMessage(id);
    }

    private void sendMessage(UUID id) {
        if (u == id || !isElectable) {
            return;
        }

        u = id;
        Set<Map.Entry<Integer, Process>> s = super.destinations.entrySet();
        for (Map.Entry<Integer, Process> entry : s) {
            if (entry.getKey() > super.getID()) {
                entry.getValue().receiveMessage(new Message(Message.MessageType.ELECT, super.getID(), id));
            }
        }

        iswaiting = true;
    }

    @Override
    public void run() {
        while (true) {
            Message m = null;
            try {
                m = msgQueue.poll(1L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (m == null && isElectable && super.active && iswaiting) {
                System.out.println(super.getID() + ": I'm the new master!");
                iswaiting = false;
            } else if (m != null) {
                if (m.getType() == Message.MessageType.ELECT) {
                    destinations.get(m.getSender()).receiveMessage(new Message(Message.MessageType.RESPONSE, super.getID(), m.getUuid()));
                    sendMessage(m.getUuid());
                } else {
                    isElectable = false;
                }
            }
        }
    }
}
