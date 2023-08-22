package com.rpc.remoting.transport;

import com.rpc.extension.SPI;
import com.rpc.remoting.dto.RpcRequest;

/**
 * send RpcRequest。

 */
@SPI
public interface RpcRequestTransport {
    /**
     * send rpc request to server and get result
     *
     * @param rpcRequest message body
     * @return data from server
     */
    Object sendRpcRequest(RpcRequest rpcRequest);
}
