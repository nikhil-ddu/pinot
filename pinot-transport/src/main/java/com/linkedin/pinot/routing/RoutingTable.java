package com.linkedin.pinot.routing;

import com.linkedin.pinot.common.query.response.ServerInstance;
import com.linkedin.pinot.transport.common.SegmentIdSet;

import java.util.List;
import java.util.Map;

public interface RoutingTable {

  /**
   * Return the candidate set of servers that hosts each segment-set.
   * The List of services are expected to be ordered so that replica-selection strategy can be
   * applied to them to select one Service among the list for each segment.
   *
   * @return SegmentSet to Servers map.
   */
  public Map<SegmentIdSet, List<ServerInstance>> findServers(RoutingTableLookupRequest request);
  
  /**
   * Initialize and start the Routing table population
   */
  public void start();
  
  
  /**
   * Shutdown Routing table cleanly
   */
  public void shutdown();
}
