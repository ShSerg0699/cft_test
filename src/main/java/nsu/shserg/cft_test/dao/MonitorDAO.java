package nsu.shserg.cft_test.dao;

import nsu.shserg.cft_test.entity.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorDAO extends JpaRepository<Monitor, Long> {
}
