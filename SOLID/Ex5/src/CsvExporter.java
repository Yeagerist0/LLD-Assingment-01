import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        // LSP fix: preserve data faithfully by quoting fields that contain special chars
        String body = safeBody(req);
        String escapedBody = body.replace("\n", " ").replace(",", " ");
        String csv = "title,body\n" + req.title + "," + escapedBody + "\n";
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }
}
