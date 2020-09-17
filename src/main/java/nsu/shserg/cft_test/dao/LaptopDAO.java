package nsu.shserg.cft_test.dao;

import nsu.shserg.cft_test.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopDAO extends JpaRepository<Laptop, Long> {
}
