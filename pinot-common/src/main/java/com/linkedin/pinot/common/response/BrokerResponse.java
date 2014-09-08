/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.linkedin.pinot.common.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * BrokerResponse
 * 
 */
public class BrokerResponse {
  private long _totalDocs;
  private long _numDocsScanned;
  private long _timeUsedMs;
  private List<JSONObject> _aggregationResults;
  private List<ResponseStatistics> _segmentStatistics;
  private List<ProcessingException> _exceptions;
  private Map<String, String> _traceInfo;
  private JSONObject _selectionResults;

  public BrokerResponse() {
    _aggregationResults = new ArrayList<JSONObject>();
    _segmentStatistics = new ArrayList<ResponseStatistics>();
    _exceptions = new ArrayList<ProcessingException>();
    _traceInfo = new HashMap<String, String>();
    _timeUsedMs = Long.MIN_VALUE;
  }

  public long getTotalDocs() {
    return _totalDocs;
  }

  public void setTotalDocs(long totalDocs) {
    _totalDocs = totalDocs;
  }

  public long getNumDocsScanned() {
    return _numDocsScanned;
  }

  public void setNumDocsScanned(long numDocsScanned) {
    _numDocsScanned = numDocsScanned;
  }

  public long getTimeUsedMs() {
    return _timeUsedMs;
  }

  public void setTimeUsedMs(long timeUsedMs) {
    _timeUsedMs = timeUsedMs;
  }

  public int getAggregationResultsSize() {
    return (_aggregationResults == null) ? 0 : _aggregationResults.size();
  }

  public java.util.Iterator<JSONObject> getAggregationResultsIterator() {
    return (_aggregationResults == null) ? null : _aggregationResults.iterator();
  }

  public void addToAggregationResults(JSONObject elem) {
    if (_aggregationResults == null) {
      _aggregationResults = new ArrayList<JSONObject>();
    }
    _aggregationResults.add(elem);
  }

  public List<JSONObject> getAggregationResults() {
    return _aggregationResults;
  }

  public void setAggregationResults(List<JSONObject> aggregationResults) {
    _aggregationResults = aggregationResults;
  }

  public JSONObject getSelectionResults() {
    return _selectionResults;
  }

  public void setSelectionResults(JSONObject selectionResults) {
    _selectionResults = selectionResults;
  }

  public int getSegmentStatisticsSize() {
    return (_segmentStatistics == null) ? 0 : _segmentStatistics.size();
  }

  public java.util.Iterator<ResponseStatistics> getSegmentStatisticsIterator() {
    return (_segmentStatistics == null) ? null : _segmentStatistics.iterator();
  }

  public void addToSegmentStatistics(ResponseStatistics elem) {
    if (_segmentStatistics == null) {
      _segmentStatistics = new ArrayList<ResponseStatistics>();
    }
    _segmentStatistics.add(elem);
  }

  public List<ResponseStatistics> getSegmentStatistics() {
    return _segmentStatistics;
  }

  public void setSegmentStatistics(List<ResponseStatistics> segmentStatistics) {
    _segmentStatistics = segmentStatistics;
  }

  public int getExceptionsSize() {
    return (_exceptions == null) ? 0 : _exceptions.size();
  }

  public java.util.Iterator<ProcessingException> getExceptionsIterator() {
    return (_exceptions == null) ? null : _exceptions.iterator();
  }

  public void addToExceptions(ProcessingException elem) {
    if (_exceptions == null) {
      _exceptions = new ArrayList<ProcessingException>();
    }
    _exceptions.add(elem);
  }

  public List<ProcessingException> getExceptions() {
    return _exceptions;
  }

  public void setExceptions(List<ProcessingException> exceptions) {
    _exceptions = exceptions;
  }

  public int getTraceInfoSize() {
    return (_traceInfo == null) ? 0 : _traceInfo.size();
  }

  public void putToTraceInfo(String key, String val) {
    if (_traceInfo == null) {
      _traceInfo = new HashMap<String, String>();
    }
    _traceInfo.put(key, val);
  }

  public Map<String, String> getTraceInfo() {
    return _traceInfo;
  }

  public void setTraceInfo(Map<String, String> traceInfo) {
    _traceInfo = traceInfo;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("BrokerResponse(");

    sb.append("totalDocs:");
    sb.append(_totalDocs);

    sb.append(", ");
    sb.append("numDocsScanned:");
    sb.append(_numDocsScanned);

    sb.append(", ");
    sb.append("timeUsedMs:");
    sb.append(_timeUsedMs);
    sb.append(", ");
    sb.append("aggregationResults:");
    if (_aggregationResults == null) {
      sb.append("null");
    } else {
      sb.append(_aggregationResults);
    }
    sb.append(", ");
    sb.append("selectionResults:");
    if (_selectionResults == null) {
      sb.append("null");
    } else {
      sb.append(_selectionResults);
    }
    sb.append(", ");
    sb.append("segmentStatistics:");
    if (_segmentStatistics == null) {
      sb.append("null");
    } else {
      sb.append(_segmentStatistics);
    }
    sb.append(", ");
    sb.append("exceptions:");
    if (_exceptions == null) {
      sb.append("null");
    } else {
      sb.append(_exceptions);
    }
    sb.append(", ");
    sb.append("traceInfo:");
    if (_traceInfo == null) {
      sb.append("null");
    } else {
      sb.append(_traceInfo);
    }
    sb.append(")");
    return sb.toString();
  }

  public JSONObject toJson() throws JSONException {
    JSONObject retJsonObject = new JSONObject();
    retJsonObject.put("totalDocs", _totalDocs);
    retJsonObject.put("timeUsedMs", _timeUsedMs);
    retJsonObject.put("numDocsScanned", _numDocsScanned);
    retJsonObject.put("aggregationResults", new JSONArray(_aggregationResults));
    retJsonObject.put("selectionResults", _selectionResults);
    retJsonObject.put("segmentStatistics", new JSONArray(_segmentStatistics));
    retJsonObject.put("exceptions", new JSONArray(_exceptions));
    JSONObject traceInfo = new JSONObject();
    for (String key : _traceInfo.keySet()) {
      traceInfo.put(key, traceInfo.get(key));
    }
    retJsonObject.put("traceInfo", traceInfo);
    return retJsonObject;
  }
}
