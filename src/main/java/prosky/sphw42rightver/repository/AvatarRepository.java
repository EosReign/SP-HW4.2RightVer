package prosky.sphw42rightver.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import prosky.sphw42rightver.entity.Avatar;

import java.util.Optional;

@Repository
public interface AvatarRepository extends PagingAndSortingRepository<Avatar, Long> {
    Optional<Avatar> findByStudentId(long studentId);

    void save(Avatar avatar);
}
