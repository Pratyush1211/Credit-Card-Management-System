package com.citi.creditcard.repository;

import com.citi.creditcard.dto.CitiesInfoDTO;
import com.citi.creditcard.dto.MerchantInfoDTO;
import com.citi.creditcard.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDALMongoTemplate {

    @Autowired
    private MongoTemplate mongoTemplate;

    public MerchantInfoDTO findMerchantTransactionDetails(String merchant) {
        Query query = new Query(Criteria.where("merchant").is(merchant));

        List<Transaction> transactions = mongoTemplate.find(query, Transaction.class);
        double totalAmount = transactions.stream().mapToDouble(Transaction::getAmount).sum();

        MerchantInfoDTO merchantInfoDTO = new MerchantInfoDTO();
        merchantInfoDTO.setMerchant(merchant);
        merchantInfoDTO.setTotal_amount(totalAmount);
        merchantInfoDTO.setTransactionCount(transactions.size());
        return merchantInfoDTO;
    }

    public CitiesInfoDTO findCityTransactionDetails(String city) {
        Query query = new Query(Criteria.where("city").is(city));

        List<Transaction> transactions = mongoTemplate.find(query, Transaction.class);
        double totalAmount = transactions.stream().mapToDouble(Transaction::getAmount).sum();

        CitiesInfoDTO cityInfoDTO = new CitiesInfoDTO();
        cityInfoDTO.setCity(city);
        cityInfoDTO.setTotal_amount(totalAmount);
        cityInfoDTO.setTransactionCount(transactions.size());
        return cityInfoDTO;
    }

}
