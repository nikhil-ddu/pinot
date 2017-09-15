/**
 * Copyright (C) 2014-2016 LinkedIn Corp. (pinot-core@linkedin.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.linkedin.pinot.server.api.resources;

import com.google.common.collect.ImmutableList;
import com.linkedin.pinot.common.restlet.resources.ServerPerfMetrics;
import com.linkedin.pinot.core.data.manager.offline.InstanceDataManager;
import com.linkedin.pinot.core.data.manager.offline.SegmentDataManager;
import com.linkedin.pinot.core.data.manager.offline.TableDataManager;
import com.linkedin.pinot.core.indexsegment.IndexSegment;
import com.linkedin.pinot.server.starter.ServerInstance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.Collection;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * API to provide server performance metrics, for example all hosted segments count and storage size
 */
@Api(tags = "ServerPerfResource")
@Path("/")

public class ServerPerfResource {
  private static final Logger LOGGER = LoggerFactory.getLogger(ServerPerfResource.class);

  @Inject
  ServerInstance serverInstance;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/ServerPerfMetrics/SegmentInfo")
  @ApiOperation(value = "Show all hosted segments count and storage size", notes = "Storage size and count of all segments hosted by a Pinot Server")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 500, message = "Internal server error")})
  public ServerPerfMetrics getSegmentsSize() throws WebApplicationException {
    InstanceDataManager dataManager = (InstanceDataManager) serverInstance.getInstanceDataManager();
    if (dataManager == null) {
      throw new WebApplicationException("Invalid server initialization", Response.Status.INTERNAL_SERVER_ERROR);
    }
    ServerPerfMetrics serverPerfMetrics = new ServerPerfMetrics();
    Collection<TableDataManager> tableDataManagers = dataManager.getTableDataManagers();
    for (TableDataManager tableDataManager : tableDataManagers) {
      ImmutableList<SegmentDataManager> segmentDataManagers = tableDataManager.acquireAllSegments();
      try {
        serverPerfMetrics.segmentCount += segmentDataManagers.size();
        for (SegmentDataManager segmentDataManager : segmentDataManagers) {
          IndexSegment segment = segmentDataManager.getSegment();
          serverPerfMetrics.segmentDiskSizeInBytes += segment.getDiskSizeBytes();
        }
      } finally {
        // we could release segmentDataManagers as we iterate in the loop above
        // but this is cleaner with clear semantics of usage. Also, above loop
        // executes fast so duration of holding segments is not a concern
        for (SegmentDataManager segmentDataManager : segmentDataManagers) {
          tableDataManager.releaseSegment(segmentDataManager);
        }
      }
    }
    return serverPerfMetrics;
  }
}
