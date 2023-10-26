package Model.Orders.Get;

import java.util.List;

public class GetOrdersResponseApiModel
{
    private List<OrdersResponse> orders;
    private PageInfoResponse pageInfo;
    private List<AvailableStationsResponce> availableStations;

    public List<OrdersResponse> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdersResponse> orders) {
        this.orders = orders;
    }

    public PageInfoResponse getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfoResponse pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<AvailableStationsResponce> getAvailableStations() {
        return availableStations;
    }

    public void setAvailableStations(List<AvailableStationsResponce> availableStations) {
        this.availableStations = availableStations;
    }
}
