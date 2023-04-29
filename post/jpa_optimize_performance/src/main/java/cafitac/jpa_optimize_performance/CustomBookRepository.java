package cafitac.jpa_optimize_performance;

import java.util.List;

public interface CustomBookRepository {

    void bulkSave(List<Book> books);
}
