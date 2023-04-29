package cafitac.jpa_optimize_performance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long>, CustomAuthorRepository {

}
