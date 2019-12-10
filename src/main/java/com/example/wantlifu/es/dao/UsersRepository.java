package com.example.wantlifu.es.dao;

import com.example.wantlifu.mbg.model.Users;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * @author 王志坚
 * @createTime 2019.12.10.11:50
 */
public interface UsersRepository extends ElasticsearchCrudRepository<Users,Integer> {
    Users queryUsersByUserid(Integer id);
}
