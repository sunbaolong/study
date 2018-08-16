package sbl.knights;

/**
 * @author sunbaolong(sunbaolong@daojia.com)
 * @date 2018/6/30
 */
public class BraveKnight implements Knight {
    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
