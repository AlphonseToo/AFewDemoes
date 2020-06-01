package com.spring.in.action.chapter01;

/**
 *
 *
 * @author Alphonse
 * @date 2020/6/1 11:18
 * @since 1.0
 **/
public class DamselRescuingKnight implements Knight {
    private Quest quest;
    public DamselRescuingKnight(Quest quest) {
        this.quest = quest; // 紧耦合
    }
    public void embarkOnQuest() {
        quest.embark();
    }
}
