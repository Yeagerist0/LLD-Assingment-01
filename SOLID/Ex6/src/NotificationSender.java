/**
 * Base contract:
 * - Precondition: n must not be null. Channel-specific fields (email, phone) may vary.
 * - Postcondition: returns SendResult indicating success or failure with reason.
 * - No subtype should throw for valid Notification objects.
 * - Subtypes that do not use certain fields (e.g. subject) may ignore them silently.
 */
public abstract class NotificationSender {
    protected final AuditLog audit;
    protected NotificationSender(AuditLog audit) { this.audit = audit; }
    public abstract SendResult send(Notification n);
}
