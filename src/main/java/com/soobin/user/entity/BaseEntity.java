package com.soobin.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;   // 등록일시 자동 생성

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;   // 수정일시 자동 업데이트

    @Column(name = "created_by", length = 50, updatable = false)
    private String createdBy;           // 등록자

    @Column(name = "updated_by", length = 50)
    private String updatedBy;           // 수정자
}
