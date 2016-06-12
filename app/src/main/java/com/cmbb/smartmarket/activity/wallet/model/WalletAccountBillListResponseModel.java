package com.cmbb.smartmarket.activity.wallet.model;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/12 上午10:54
 * 修改人：N.Sun
 * 修改时间：16/6/12 上午10:54
 * 修改备注：
 */
public class WalletAccountBillListResponseModel{


    private DataEntity data;

    private String msg;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataEntity {
        private boolean last;
        private int totalPages;
        private int totalElements;
        private int size;
        private int number;
        private int numberOfElements;
        private boolean first;
        private List<ContentEntity> content;
        private List<SortEntity> sort;

        public boolean isLast() {
            return last;
        }

        public void setLast(boolean last) {
            this.last = last;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(int totalElements) {
            this.totalElements = totalElements;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getNumberOfElements() {
            return numberOfElements;
        }

        public void setNumberOfElements(int numberOfElements) {
            this.numberOfElements = numberOfElements;
        }

        public boolean isFirst() {
            return first;
        }

        public void setFirst(boolean first) {
            this.first = first;
        }

        public List<ContentEntity> getContent() {
            return content;
        }

        public void setContent(List<ContentEntity> content) {
            this.content = content;
        }

        public List<SortEntity> getSort() {
            return sort;
        }

        public void setSort(List<SortEntity> sort) {
            this.sort = sort;
        }

        public static class ContentEntity {
            private int id;
            private int accId;
            private String billType;
            private int businessId;
            private String businessCode;
            private String businessDetail;
            private String businessReason;
            private double businessBalance;
            private String status;
            private String tradeTime;
            private String tradeEndTime;
            private String tradeCloseTime;
            private String refundTime;
            private String refundEndTime;
            private String cashTime;
            private String cashEndTime;
            private String cashFailTime;
            private String createDate;
            private int createUserId;
            private String updateDate;
            private int updateUserId;
            private String statusName;
            private String viewBalance;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getAccId() {
                return accId;
            }

            public void setAccId(int accId) {
                this.accId = accId;
            }

            public String getBillType() {
                return billType;
            }

            public void setBillType(String billType) {
                this.billType = billType;
            }

            public int getBusinessId() {
                return businessId;
            }

            public void setBusinessId(int businessId) {
                this.businessId = businessId;
            }

            public String getBusinessCode() {
                return businessCode;
            }

            public void setBusinessCode(String businessCode) {
                this.businessCode = businessCode;
            }

            public String getBusinessDetail() {
                return businessDetail;
            }

            public void setBusinessDetail(String businessDetail) {
                this.businessDetail = businessDetail;
            }

            public String getBusinessReason() {
                return businessReason;
            }

            public void setBusinessReason(String businessReason) {
                this.businessReason = businessReason;
            }

            public double getBusinessBalance() {
                return businessBalance;
            }

            public void setBusinessBalance(double businessBalance) {
                this.businessBalance = businessBalance;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getTradeTime() {
                return tradeTime;
            }

            public void setTradeTime(String tradeTime) {
                this.tradeTime = tradeTime;
            }

            public String getTradeEndTime() {
                return tradeEndTime;
            }

            public void setTradeEndTime(String tradeEndTime) {
                this.tradeEndTime = tradeEndTime;
            }

            public String getTradeCloseTime() {
                return tradeCloseTime;
            }

            public void setTradeCloseTime(String tradeCloseTime) {
                this.tradeCloseTime = tradeCloseTime;
            }

            public String getRefundTime() {
                return refundTime;
            }

            public void setRefundTime(String refundTime) {
                this.refundTime = refundTime;
            }

            public String getRefundEndTime() {
                return refundEndTime;
            }

            public void setRefundEndTime(String refundEndTime) {
                this.refundEndTime = refundEndTime;
            }

            public String getCashTime() {
                return cashTime;
            }

            public void setCashTime(String cashTime) {
                this.cashTime = cashTime;
            }

            public String getCashEndTime() {
                return cashEndTime;
            }

            public void setCashEndTime(String cashEndTime) {
                this.cashEndTime = cashEndTime;
            }

            public String getCashFailTime() {
                return cashFailTime;
            }

            public void setCashFailTime(String cashFailTime) {
                this.cashFailTime = cashFailTime;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public int getCreateUserId() {
                return createUserId;
            }

            public void setCreateUserId(int createUserId) {
                this.createUserId = createUserId;
            }

            public String getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(String updateDate) {
                this.updateDate = updateDate;
            }

            public int getUpdateUserId() {
                return updateUserId;
            }

            public void setUpdateUserId(int updateUserId) {
                this.updateUserId = updateUserId;
            }

            public String getStatusName() {
                return statusName;
            }

            public void setStatusName(String statusName) {
                this.statusName = statusName;
            }

            public String getViewBalance() {
                return viewBalance;
            }

            public void setViewBalance(String viewBalance) {
                this.viewBalance = viewBalance;
            }
        }

        public static class SortEntity {
            private String direction;
            private String property;
            private boolean ignoreCase;
            private String nullHandling;
            private boolean ascending;

            public String getDirection() {
                return direction;
            }

            public void setDirection(String direction) {
                this.direction = direction;
            }

            public String getProperty() {
                return property;
            }

            public void setProperty(String property) {
                this.property = property;
            }

            public boolean isIgnoreCase() {
                return ignoreCase;
            }

            public void setIgnoreCase(boolean ignoreCase) {
                this.ignoreCase = ignoreCase;
            }

            public String getNullHandling() {
                return nullHandling;
            }

            public void setNullHandling(String nullHandling) {
                this.nullHandling = nullHandling;
            }

            public boolean isAscending() {
                return ascending;
            }

            public void setAscending(boolean ascending) {
                this.ascending = ascending;
            }
        }
    }
}
