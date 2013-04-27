package blatt4;

import java.util.UUID;

public class Message {
	public enum MessageType {
		ELECT, RESPONSE
	}

    public static volatile long last_uuid = 0L;

	private final MessageType type;
	private final int sender;
	private final UUID uuid;

	public Message(MessageType type, int sender, UUID uuid) {
		this.type = type;
		this.sender = sender;
		this.uuid = uuid;
	}

	public int getSender() {
		return sender;
	}

	public MessageType getType() {
		return type;
	}

	public UUID getUuid() {
		return uuid;
	}

    public final String toString() {
        return type.toString() + " : " + sender + " : " + uuid.toString();
    }

    public static synchronized long getLast_uuid() {
        return last_uuid++;
    }
}
