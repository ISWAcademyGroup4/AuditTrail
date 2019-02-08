package com.interswitch.audittrail.dao;

import com.interswitch.audittrail.domain.AuditTrail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends MongoRepository<AuditTrail,String> {
}
