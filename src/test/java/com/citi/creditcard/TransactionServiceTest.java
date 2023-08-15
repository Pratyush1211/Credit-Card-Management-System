package com.citi.creditcard;

import com.citi.creditcard.entity.Transaction;
import com.citi.creditcard.repository.TransactionRepository;
import com.citi.creditcard.services.TransactionService;
import org.apache.catalina.users.SparseUserDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransactionServiceTest {

    //Testing service layer
    @Mock
    TransactionRepository repo;
    @InjectMocks
    TransactionService service;

    //Arrange the fixtures -step 1

    //Create list of Transaction objects
    List<Transaction> collection;

    Transaction t1,t2,t3;

    @BeforeEach
    public void befAll(){
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void setUp(){
        t1=new Transaction("08/02/2001","sania","F","singh","Botsford and Sons","Seismic interpreter","ok",30.22,"15/04/2019 13:38","health_fitness","67","Achille",74710,1001);
        t2=new Transaction("22/01/2001","rohit","M","roy","Jones","engineer","ok",20.22,"17/05/2019 13:38","education","77","Pune",74810,1011);
        t3=new Transaction("13/10/2008","ashika","F","sen","Cummerata-Jones","sde","ok",50.22,"18/08/2019 13:38","education","79","Delhi",84810,1021);

        collection= Arrays.asList(t1,t2,t3);
    }


    //Act
    @Test
    public void getByMerchantTest(){
        List<Transaction> ans=Arrays.asList(t3);
        when(repo.findByMerchant("Cummerata-Jones")).thenReturn(ans);

        List<Transaction> listReceived=service.getAllByMerchant("Cummerata-Jones");

        assertEquals(ans,listReceived);
    }

    @Test
    public void getByCityTest(){
        List<Transaction> ans=Arrays.asList(t3);
        when(repo.findByCity("Delhi")).thenReturn(ans);

        List<Transaction> listReceived=service.getAllByCity("Delhi");

        assertEquals(ans,listReceived);
    }

    @Test
    public void getByStateTest(){
        List<Transaction> ans=Arrays.asList(t3,t1,t2);
        when(repo.findByState("ok")).thenReturn(ans);

        List<Transaction> listReceived=service.getAllByState("ok");

        assertEquals(ans,listReceived);
    }

    @Test
    public void getByStateDistinctTest(){
        List<String> ans=Arrays.asList("ok");
        when(repo.findDistinctStateValues()).thenReturn(ans);

        List<String> listReceived=service.getAllDistinctStates();

        assertEquals(ans,listReceived);
    }

    @Test
    public void getByDistinctCityTest(){
        List<String> ans=Arrays.asList("Delhi","Pune","Achille");
        when(repo.findDistinctCityValues()).thenReturn(ans);
        List<String> listReceived=service.getAllDistinctCity();

        assertEquals(ans,listReceived);
    }

}
