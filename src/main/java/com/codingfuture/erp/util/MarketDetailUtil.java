package com.codingfuture.erp.util;

import com.codingfuture.erp.dto.GoodsSaleDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MarketDetailUtil {
    private List<GoodsSaleDTO> marketDetails;

    private String customeruuid;

}
