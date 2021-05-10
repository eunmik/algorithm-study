package com.eunmi.algorithm;

import com.eunmi.TDD.Account;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.crypto.Cipher;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    private static Account account;

    //계좌를 생성한다 -> 계좌가 정상적으로 생성됐는지 확인한다
    @Test
    public void testAccount() throws Exception { //1. 테스트 메소드를 만든다.
        setup();
    }

    @Test
    public void testGetBalance() throws Exception {
        setup();
        //예상값과 실제값을 비교하는 조건을 만족하지 않으면 실패!
        //Junit 버전
        //assertEquals(예상값, 실제값)
        //assertEquals(예상값, 실제값, "설명")
        assertEquals(10000, account.getBalance(), "10000원으로 계좌 생성 후 잔고 조회");
        account = new Account(1000);
        assertEquals(1000, account.getBalance());
        account = new Account(0);
        assertEquals(0, account.getBalance());
    }

    @Test
    public void testDeposit() throws Exception{
        setup();
        account.deposit(1000);
        assertEquals(11000, account.getBalance());
    }

    @Test
    public void testWithdraw() throws Exception{
        setup();
        account.withdraw(1000);
        assertEquals(9000, account.getBalance());

    }

    @BeforeAll
    public static void setup(){
        account = new Account(10000);
    }

}
