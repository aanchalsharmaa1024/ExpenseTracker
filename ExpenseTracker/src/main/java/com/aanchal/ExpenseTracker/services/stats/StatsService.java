package com.aanchal.ExpenseTracker.services.stats;

import com.aanchal.ExpenseTracker.dto.GraphDTO;
import com.aanchal.ExpenseTracker.dto.StatsDTO;

public interface StatsService {

    GraphDTO getChartData();
    StatsDTO getStats();
}
