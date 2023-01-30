import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task {
    private String task;
    private LocalDateTime start;
    private LocalDateTime end;
    private DateTimeFormatter acceptingFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HHmm");
    private DateTimeFormatter displayFormat = DateTimeFormatter.ofPattern("dd/MMM/yyyy HHmm");

    public Event(String task, String start, String end) {
        super(task);
        try {
            LocalDateTime temp = LocalDateTime.parse(start, acceptingFormat);
            this.start = LocalDateTime.parse(temp.format(displayFormat), displayFormat);
            this.task = task;
        } catch (DateTimeParseException e) {
            throw new DateTimeParseException(end, end, 0);
            } try {
                LocalDateTime temp = LocalDateTime.parse(end, acceptingFormat);
                this.end = LocalDateTime.parse(temp.format(displayFormat), displayFormat);
        } catch (DateTimeParseException e) {
            throw new DateTimeParseException(end, end, 0);
        }
            
    }

    @Override
    public String getTask() {
        return this.task;
    }

    public String getStart() {
        return this.start.format(displayFormat);
    }

    public String getEnd() {
        return this.end.format(displayFormat);
    }

    @Override
    public String toString() {
        return "[E] " + super.toString() + " (from: " + this.start.format(displayFormat) + 
            " to: " + this.end.format(displayFormat) + "Hrs" + ")";
    }
}
