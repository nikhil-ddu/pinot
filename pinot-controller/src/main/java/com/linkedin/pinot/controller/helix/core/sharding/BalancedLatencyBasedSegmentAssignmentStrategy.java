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
package com.linkedin.pinot.controller.helix.core.sharding;

import com.linkedin.pinot.common.segment.SegmentMetadata;
import com.linkedin.pinot.controller.helix.core.PinotHelixResourceManager;
import org.apache.helix.HelixAdmin;
import org.apache.helix.ZNRecord;
import org.apache.helix.store.zk.ZkHelixPropertyStore;

import java.util.List;

public class BalancedLatencyBasedSegmentAssignmentStrategy implements SegmentAssignmentStrategy {

    @Override
    public List<String> getAssignedInstances(PinotHelixResourceManager helixResourceManager,
                                             ZkHelixPropertyStore<ZNRecord> propertyStore, String helixClusterName,
                                             SegmentMetadata segmentMetadata, int numReplicas, String tenantName) {
        //We create a SegmentSizeMetric and pass it to BalancedLoadSegmentAssignmentStrategy
        //This means BalancedSegmentSizeSegmentAssignmentStrategy
        ServerLoadMetric serverLoadMetric = new LatencyBasedLoadMetric();
        BalancedLoadSegmentAssignmentStrategy BalancedLoadSegmentAssignmentStrategy = new BalancedLoadSegmentAssignmentStrategy(serverLoadMetric);
        return BalancedLoadSegmentAssignmentStrategy.getAssignedInstances(helixResourceManager, propertyStore, helixClusterName,
                segmentMetadata, numReplicas, tenantName);
    }

    @Override
    public List<String> getAssignedInstances(HelixAdmin helixAdmin, ZkHelixPropertyStore<ZNRecord> propertyStore, String helixClusterName, SegmentMetadata segmentMetadata, int numReplicas, String tenantName) {
        return null;
    }
}

