package workflow.example.workflow.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import workflow.example.workflow.entity.GroupeUser;

@Repository
public interface GroupeUserRepository extends JpaRepository<GroupeUser,Long> {
}
