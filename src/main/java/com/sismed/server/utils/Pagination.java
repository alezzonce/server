package com.sismed.server.utils;

import java.util.List;
import lombok.Data;

/**
 * Model to represent a page to handle the pagination with values currentPage, data, pageSize,
 * total, totalElements, page
 *
 * @param <T> is a entity type
 */
@Data
public class Pagination<T> {
  private int currentPage;
  private List<T> data;
  private int pageSize;
  private int total;
  private long totalElements;
  private int page;
}