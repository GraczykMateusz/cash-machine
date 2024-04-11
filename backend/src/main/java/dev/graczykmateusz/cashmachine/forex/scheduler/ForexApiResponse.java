package dev.graczykmateusz.cashmachine.forex.scheduler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
class ForexApiResponse {
    
    String ticker;
    int queryCount;
    int resultCount;
    boolean adjusted;
    List<ForexApiResult> results;
    String status;
    String requestId;
    int count;
}