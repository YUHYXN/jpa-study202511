package com.codeit.jpastudy.chap05.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 웬만하면 엔터티에 @Setter 쓰지마라. 변경 불가능한 객체로 설계하는게 좋다.
@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)    // 계좌번호는 유일해야하니 유니크 = true
    private String accountNumber;

    @Column(nullable = false)
    private String ownerName;

    @Column(nullable = false, precision = 19, scale = 0)   // 소수점 둘째자리까지 표현
    private BigDecimal balance = BigDecimal.ZERO;   // Long보다 더 큰 정수를 표현하고 싶을 때.

    // id는 자동 생성되니 생성자에서 제외
    public Account(String accountNumber, String ownerName, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // 입금
    public void deposit(BigDecimal amount) {
       if (amount.compareTo(BigDecimal.ZERO) <= 0) {    // BigDecimal.ZERO랑 비교했을 때 금액이 0보다 작거나 같아?
              throw new IllegalArgumentException("입금 금액은 0보다 커야 합니다.");
       }
       // 입금 처리 (더하기는 add)
       this.balance = this.balance.add(amount);   // 잔액에 입금할 금액을 더하라.
    }

    // withdraw 빨간줄 제거를 위한 메서드 선언
    public void withdraw(BigDecimal amount) {
       if (amount.compareTo(BigDecimal.ZERO) <= 0) {    // BigDecimal.ZERO랑 비교했을 때 금액이 0보다 작거나 같아?
              throw new IllegalArgumentException("출금 금액은 0보다 커야 합니다.");
       }
       if (this.balance.compareTo(amount) <= 0) {   // 이게 뭐냐면 잔액이 출금할 금액보다 작거나 같아?
              throw new IllegalArgumentException("잔액이 부족합니다.");
       }
       // 잔액이 부족하지 않다면 출금 처리 (빼기는 subtract)
         this.balance = this.balance.subtract(amount);   // 잔액에서 출금할 금액을 빼라.
    }






}
