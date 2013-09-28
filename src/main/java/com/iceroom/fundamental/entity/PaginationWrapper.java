package com.iceroom.fundamental.entity;

import java.util.List;

/**
 * The wrapper class for pagination support.<br/>
 * The default page size is 20.
 * @author Lincoln
 *
 */
public class PaginationWrapper {

    public final static int PAGESIZE = 20; // Default page sizeis 20

    private int pageSize = PAGESIZE;

    private int totalCount;

    @SuppressWarnings("unused")
    private int currentPage;

    private int startIndex;

    private int[] indexes = new int[0];

    @SuppressWarnings("unused")
    private int nextIndex;

    @SuppressWarnings("unused")
    private int previousIndex;

    @SuppressWarnings("unused")
    private int pageCount;

    @SuppressWarnings("rawtypes")
    private List items;

    @SuppressWarnings("unused")
    private int lastIndex;

    public PaginationWrapper(int pageSize, int startIndex) {
        setPageSize(pageSize);
        setStartIndex(startIndex);
    }

    public PaginationWrapper(@SuppressWarnings("rawtypes") List items, int totalCount) {
        setPageSize(PAGESIZE);
        setTotalCount(totalCount);
        setItems(items);
        setStartIndex(0);

    }

    public PaginationWrapper(@SuppressWarnings("rawtypes") List items, int totalCount, int startIndex) {
        setPageSize(PAGESIZE);
        setTotalCount(totalCount);
        setItems(items);
        setStartIndex(startIndex);

    }

    /**
     * This constructor is used mostly.
     * @param items The result colloection of current page.
     * @param totalCount The total number of inquiry result.
     * @param pageSize The page size.
     * @param startIndex The start index of current page.
     */
    public PaginationWrapper(@SuppressWarnings("rawtypes") List items,
            int totalCount, int pageSize, int startIndex) {
        setPageSize(pageSize);
        setTotalCount(totalCount);
        setItems(items);
        setStartIndex(startIndex);

    }

    public PaginationWrapper(int pageSize, int totalCount, int currentPage,
            int startIndex, int nextIndex, int previousIndex,
            int pageCount, @SuppressWarnings("rawtypes") List items, int lastIndex) {
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.startIndex = startIndex;
        this.nextIndex = nextIndex;
        this.previousIndex = previousIndex;
        this.pageCount = pageCount;
        this.items = items;
        this.lastIndex = lastIndex;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount > 0) {
            this.totalCount = totalCount;
            int count = totalCount / pageSize;
            if (totalCount % pageSize > 0)
                count++;
            indexes = new int[count];
            for (int i = 0; i < count; i++) {
                indexes[i] = pageSize * i;
            }
        } else {
            this.totalCount = 0;
        }
    }
    
    public int getTotalCount() {
        return totalCount;
    }
    
    public void setIndexes(int[] indexes) {
        this.indexes = indexes;
    }
    
    public int[] getIndexes() {
        return indexes;
    }

    public void setStartIndex(int startIndex) {
        if (totalCount <= 0)
            this.startIndex = 0;
        else if (startIndex >= totalCount)
            this.startIndex = indexes[indexes.length - 1];
        else if (startIndex < 0)
            this.startIndex = 0;
        else {
            this.startIndex = indexes[startIndex / pageSize];
        }
    }
    
    public int getStartIndex() {
        return startIndex;
    }

    public void setNextIndex(int nextIndex) {
        this.nextIndex = nextIndex;
    }
    
    public int getNextIndex() {
        int nextIndex = getStartIndex() + pageSize;
        if (nextIndex >= totalCount)
            return getStartIndex();
        else
            return nextIndex;
    }
    
    public void setPreviousIndex(int previousIndex) {
        this.previousIndex = previousIndex;
    }

    public int getPreviousIndex() {
        int previousIndex = getStartIndex() - pageSize;
        if (previousIndex < 0)
            return 0;
        else
            return previousIndex;
    }
    
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    public int getPageCount() {
        int count = totalCount / pageSize;
        if (totalCount % pageSize > 0)
            count++;
        return count;
    }

    public int getCurrentPage() {
        return getStartIndex() / pageSize + 1;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setLastIndex(int lastIndex) {
        this.lastIndex =lastIndex ;
    }
    
    public int getLastIndex() {
        if(indexes.length > 0) return indexes[indexes.length-1];
        else return 0;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    @SuppressWarnings("rawtypes")
    public List getItems() {
        return items;
    }
    
    public void setItems(@SuppressWarnings("rawtypes") List items) {
        this.items = items;
    }
}
