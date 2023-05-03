package cafitac.jpa_optimize_performance;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long>, CustomBookRepository {

    @Override
    @Query("select b from Book b join fetch b.author")
    List<Book> findAll();
}
