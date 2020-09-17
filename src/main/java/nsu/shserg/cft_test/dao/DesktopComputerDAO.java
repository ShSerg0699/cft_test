package nsu.shserg.cft_test.dao;

import nsu.shserg.cft_test.entity.DesktopComputer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesktopComputerDAO extends JpaRepository<DesktopComputer, Long> {
}
