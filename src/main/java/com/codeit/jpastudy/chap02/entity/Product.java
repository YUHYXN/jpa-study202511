package com.codeit.jpastudy.chap02.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Builder
@Entity // 이 클래스는 JPA가 관리하는 엔티티 클래스입니다. || 데이터베이스의 한 행에 정확하게 대응한다.
@Table(name = "tbl_product") // 이 엔티티 클래스가 매핑될 데이터베이스 테이블 이름을 지정합니다.
public class Product {

    @Id // PK 필드를 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 숫자 자동 증가 [전략]을 지정
    @Column(name = "prod_id")   // 매핑될 테이블의 컬럼 이름을 지정
    private Long id;

    @Column(name = "prod_name", length = 30, nullable = false)  // NOT NULL 제약조건 추가 (nullable = false)
    private String name;

    @Column(name = "prod_price")
    private int price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)    // enum 타입 매핑 설정 (기본값은 ORDINAL (숫자가 들어간다))
    private Category category;

    @CreationTimestamp  // INSERT 시점에 시간이 자동으로 들어가도록 설정해준다.
    @Column(updatable = false)  // 수정불가 (생성된 시간은 변경될 일이 없다.)
    private LocalDateTime createAt;

    @UpdateTimestamp    // UPDATE 시점에 시간이 자동으로 들어가도록 설정해준다.
    private LocalDateTime updateAt;

    // 데이터베이스에는 저장 안 하고 클래스 내부에서만 사용할 필드.
    @Transient
    private String nickName;


    public enum Category {
        FOOD, FASHION, ELECTRONIC
    }


}
