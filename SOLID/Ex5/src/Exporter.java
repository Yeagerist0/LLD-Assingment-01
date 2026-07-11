public abstract class Exporter {
    /**
     * Contract:
     * - Precondition: req must not be null; req.title must not be null.
     * - Postcondition: returns a non-null ExportResult with non-null contentType and non-null bytes.
     * - No exporter may throw for valid input; if content is too large for a format,
     *   the exporter should handle it gracefully (e.g., truncate) rather than reject.
     * - Null body should be treated as empty string.
     */
    public abstract ExportResult export(ExportRequest req);

    protected String safeBody(ExportRequest req) {
        return req.body == null ? "" : req.body;
    }
}
