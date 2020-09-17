package nsu.shserg.cft_test.dao;

import nsu.shserg.cft_test.entity.HardDisk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardDiskDAO extends JpaRepository<HardDisk, Long> {
}
