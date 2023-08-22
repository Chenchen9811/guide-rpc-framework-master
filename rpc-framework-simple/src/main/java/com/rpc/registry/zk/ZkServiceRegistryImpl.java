package com.rpc.registry.zk;

import com.rpc.registry.zk.util.CuratorUtils;
import com.rpc.registry.ServiceRegistry;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;

import java.net.InetSocketAddress;

/**
 * service registration  based on zookeeper
 *
 */
@Slf4j
public class ZkServiceRegistryImpl implements ServiceRegistry {

    @Override
    public void registerService(String rpcServiceName, InetSocketAddress inetSocketAddress) {
        // "/my-rpc/rpcServiceName + 192.168.1.1
        String servicePath = CuratorUtils.ZK_REGISTER_ROOT_PATH + "/" + rpcServiceName + inetSocketAddress.toString();
        // 获取zookeeper客户端
        CuratorFramework zkClient = CuratorUtils.getZkClient();
        // 向zookeeper中这个servicePath路径下创建一个持久节点就算注册成功
        CuratorUtils.createPersistentNode(zkClient, servicePath);
    }
}
