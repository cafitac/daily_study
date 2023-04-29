package cafitac.jpa_optimize_performance;

import java.util.List;

public interface CustomAuthorRepository {

    void bulkSave(List<Author> authorList);
}
