package com.codingfuture.erp.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataResult<T> {
    private T rows;
    private Long total;
}
