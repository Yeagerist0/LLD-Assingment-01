import java.nio.charset.StandardCharsets;

public class JsonExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        // LSP fix: consistent null handling via base contract's safeBody
        String body = safeBody(req);
        String title = req.title == null ? "" : req.title;
        String json = "{\"title\":\"" + escape(title) + "\",\"body\":\"" + escape(body) + "\"}";
        return new ExportResult("application/json", json.getBytes(StandardCharsets.UTF_8));
    }

    private String escape(String s) {
        if (s == null) return "";
        return s.replace("\"", "\\\"");
    }
}
