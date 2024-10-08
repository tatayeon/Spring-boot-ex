package com.ll.spring_boot_exam_2.domain;

import com.ll.spring_boot_exam_2.jpaEntity.BaseTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Article extends BaseTime {

    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    @ManyToOne
    private Member author;


}
