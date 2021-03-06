package com.etrade.reporting;

import com.etrade.domain.model.Trade;
import com.etrade.reporting.enumuration.TradeFlow;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface TradeReportService {

    Map<LocalDate, BigDecimal> settledUSDAmountByDate(TradeFlow tradeFlow);

    List<String> getEntityRankings(TradeFlow tradeFlow);

    void add(Trade trade);

    default void validateFlow(TradeFlow tradeFlow) {
        if (tradeFlow == null) {
            throw new InvalidTradeFlowException();
        }
    }

    static class InvalidTradeFlowException extends RuntimeException{

    }

}
