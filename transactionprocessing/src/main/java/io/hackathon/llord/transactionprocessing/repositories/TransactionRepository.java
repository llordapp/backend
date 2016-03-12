package io.hackathon.llord.transactionprocessing.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.hackathon.llord.dao.domain.TransactionData;

@Repository
public interface TransactionRepository extends MongoRepository<TransactionData, String> {
	public TransactionData findTransactionDataByTransactionId(String transactionId);
}
