package com.github.msidd.demo.repo;

import com.github.msidd.demo.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by msidd on 11/20/2015.
 */
public interface UserRepository extends PagingAndSortingRepository<User,String> {
    User findByUserName(String userName);

}
