package io.io.dto.Response;

import java.util.List;

public class IdListResponse {
    private List<Long> ids;

    public IdListResponse(List<Long> ids) {
        this.ids = ids;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
