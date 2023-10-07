package com.sismed.server.utils;

import java.util.List;
import lombok.Data;

/**
 * clase tipo ENUM para el tipo de respuesta de la API REST de Spring Boot
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