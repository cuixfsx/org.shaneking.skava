/*
 * @(#)SKColumn.java		Created at 2017/9/10
 *
 * Copyright (c) ShaneKing All rights reserved.
 * ShaneKing PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.shaneking.skava.sql.annotation;

import org.shaneking.skava.ling.lang.String0;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @see javax.persistence.Column
 */
@Target(FIELD)
@Retention(RUNTIME)
@Inherited
public @interface SKColumn {

  /**
   * (Optional) Whether the column is included in SQL WHERE statements generated by the persistence provider.
   */
  boolean canWhere() default true;

  /**
   * (Optional) The SQL fragment that is used when generating the DDL for the column.
   * <p> Defaults to the generated SQL to create a column of the inferred type.
   */
  String dataType() default "VARCHAR";

  /**
   * (Optional) The column length. (Applies only if a string-valued column is used.)
   */
  int length() default 255;

  /**
   * (Optional) The name of the column. Defaults to the property or field name.
   */
  String name() default String0.EMPTY;

  boolean useLike() default false;

}
