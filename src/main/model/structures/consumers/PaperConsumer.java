package model.structures.consumers;

import model.resources.Paper;

/**
 * Created by allisonaguirre on 4/15/17.
 */
public interface PaperConsumer extends Consumer {
    public void addPaper(Paper paper);
}
