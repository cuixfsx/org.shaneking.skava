package org.shaneking.skava.lang;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.shaneking.skava.util.Regex0;

import java.util.Arrays;

@Slf4j
public class Object0 {
  //if return null, maybe real null or exception
  public static Object gs(@NonNull Object o, @NonNull String fields) {
    return Object0.gs(o, fields.split(Regex0.DOT));
  }

  //if return null, maybe some field unInstance or exception
  public static <T> Object gs(@NonNull Object o, @NonNull String fields, T t) {
    Object rtn = o;
    Object penultimate = o;
    String[] fieldArray = fields.split(Regex0.DOT);
    if (fieldArray.length > 1) {
      penultimate = Object0.gs(o, Arrays.copyOf(fieldArray, fieldArray.length - 1));
      rtn = null;
    }
    if (penultimate != null) {
      String last = fieldArray[fieldArray.length - 1];
      try {
        penultimate.getClass().getMethod("set" + last.substring(0, 1).toUpperCase() + last.substring(1), t.getClass()).invoke(penultimate, t);
        rtn = o;
      } catch (Exception e) {
        log.error(e.getMessage(), e);
      }
    }
    return rtn;
  }

  private static Object gs(@NonNull Object o, @NonNull String[] fields) {
    return Object0.gs(o, fields, 0);
  }

  private static Object gs(@NonNull Object o, @NonNull String[] fields, int index) {
    Object rtn = null;
    if (fields.length > index) {
      try {
        rtn = Object0.gs(o.getClass().getMethod("get" + fields[index].substring(0, 1).toUpperCase() + fields[index].substring(1)).invoke(o), fields, ++index);
      } catch (Exception e) {
        log.error(e.getMessage(), e);
      }
    } else {
      rtn = o;
    }
    return rtn;
  }
}
