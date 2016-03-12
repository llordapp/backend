package io.hackathon.llord.paymentrequests.repository;

import io.hackathon.llord.dao.domain.TransactionData;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<TransactionData, String>
{
}
