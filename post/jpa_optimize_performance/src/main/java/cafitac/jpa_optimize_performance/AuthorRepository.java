package cafitac.jpa_optimize_performance;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long>, CustomAuthorRepository {

    @Override
    <S extends Author> List<S> saveAll(Iterable<S> entities);
}
