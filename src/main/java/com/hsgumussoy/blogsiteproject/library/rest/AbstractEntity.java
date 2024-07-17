package com.hsgumussoy.blogsiteproject.library.rest;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass // AbstractEntity sınıfını MappedSuperclass olarak işaretleyin
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private Long id;

    @CreatedDate//: Bu alan entity ilk oluşturulduğunda otomatik olarak ayarlanır.
    private Date created;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)//Bu alanın hem tarih hem de saat bilgisini içereceğini belirtir.
    private Date modified;
}
