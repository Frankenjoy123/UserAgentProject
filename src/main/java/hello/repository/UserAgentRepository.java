package hello.repository;

import hello.repository.basic.FindOneAndSaveRepository;
import hello.entity.UserAgentEntity;

/**
 * Created by yunsu on 2016/5/20.
 */
public interface UserAgentRepository extends FindOneAndSaveRepository<UserAgentEntity, String> {
    void delete(String id);
    UserAgentEntity findByHashCode(int hashCode);
}
