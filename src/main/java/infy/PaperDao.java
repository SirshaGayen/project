package infy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import infy.Paper;
import infy2.Paper12;

@Repository
public interface PaperDao extends JpaRepository<Paper, Integer>{

	
}
