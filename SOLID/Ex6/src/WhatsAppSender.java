public class WhatsAppSender extends NotificationSender {
    public WhatsAppSender(AuditLog audit) { super(audit); }

    @Override
    public SendResult send(Notification n) {
        // LSP fix: instead of throwing, return error result gracefully
        if (n.phone == null || !n.phone.startsWith("+")) {
            audit.add("WA failed");
            return SendResult.error("phone must start with + and country code");
        }
        System.out.println("WA -> to=" + n.phone + " body=" + n.body);
        audit.add("wa sent");
        return SendResult.ok();
    }
}
