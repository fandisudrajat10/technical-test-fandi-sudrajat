package com.enamduateknologi.teknikaltest.dto;

import java.util.Objects;

public class SearchDto {
    private int page = 1;
    private int size;
    private String sort;

    public SearchDto() {
    }

    public int getPage() {
        return this.page;
    }

    public int getSize() {
        return this.size;
    }

    public String getSort() {
        return this.sort;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SearchDto)) {
            return false;
        } else {
            SearchDto other = (SearchDto)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getPage() != other.getPage()) {
                return false;
            } else if (this.getSize() != other.getSize()) {
                return false;
            } else {
                Object this$sort = this.getSort();
                Object other$sort = other.getSort();
                if (this$sort == null) {
                    if (other$sort == null) {
                        return true;
                    }
                } else if (this$sort.equals(other$sort)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof SearchDto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, size, sort);
    }

    public String toString() {
        return "SearchDto(page=" + this.getPage() + ", size=" + this.getSize() + ", sort=" + this.getSort() + ")";
    }
}
