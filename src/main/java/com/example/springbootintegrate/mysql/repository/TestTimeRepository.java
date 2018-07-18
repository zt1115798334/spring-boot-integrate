package com.example.springbootintegrate.mysql.repository;

import com.example.springbootintegrate.mysql.entity.TestTime;
import org.springframework.data.repository.CrudRepository;

public interface TestTimeRepository extends CrudRepository<TestTime, Long> {
}
