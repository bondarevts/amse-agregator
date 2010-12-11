package ru.amse.agregator.quality.clusterization.merge;

import ru.amse.agregator.quality.clusterization.clusterstorage.Cluster;
import ru.amse.agregator.storage.DBWrapper;

/**
 *
 * @author pavel
 *
 * Abstract class that merges a single cluster and returns
 * merged object
 */
abstract public class ClusterMerger {

    abstract public DBWrapper mergeCluster(Cluster cluster);

}
