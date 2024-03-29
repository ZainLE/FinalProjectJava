package org.edu.harbour.space.university.message;

public class MessageReject extends Message {
    public MessageReject(String originator, String messageId) {
        super(originator, messageId, false, true, 0, 0.0, "");
    }
}