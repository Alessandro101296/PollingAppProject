package io.io.dto;

import java.util.List;

public class IdListResp {
    private List<Long> ids;

    public IdListResp(List<Long> ids) {
        this.ids = ids;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
