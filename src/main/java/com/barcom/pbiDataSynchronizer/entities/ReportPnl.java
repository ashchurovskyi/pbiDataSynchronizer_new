package com.barcom.pbiDataSynchronizer.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "report_pnl")
public class ReportPnl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "report_period")
    LocalDateTime reportPeriod;

    @Column(name = "cost_item")
    String costItem;

    @Column(name = "shop_desc")
    String shopDesc;

    @Column(name = "amount")
    double amount;

    @Column(name = "cost_item_parent1")
    String costItemParent1;

    @Column(name = "cost_item_parent2")
    String costItemParent2;

    @Column(name = "cost_item_parent3")
    String costItemParent3;

    @Column(name = "cost_item_parent4")
    String costItemParent4;

    @Column(name = "cost_item_parent5")
    String costItemParent5;
}
