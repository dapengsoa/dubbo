/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.dubbo.rpc;

import com.alibaba.dubbo.common.Node;

/**
 * Invoker. (API/SPI, Prototype, ThreadSafe)
 * <p>
 * Invoker,一个可执行对象，能够根据方法名称、参数得到相应的执行结果
 * <p>
 * Invoker 执行过程分为三种类型：
 * 1.本地执行的Invoker
 * 2.远程通讯执行的Invoker
 * 3.多个类型的Invoker聚合而成的集群版的Invoker
 *
 * @see com.alibaba.dubbo.rpc.Protocol#refer(Class, com.alibaba.dubbo.common.URL)
 * @see com.alibaba.dubbo.rpc.InvokerListener
 * @see com.alibaba.dubbo.rpc.protocol.AbstractInvoker
 */
public interface Invoker<T> extends Node {

    /**
     * get service interface.
     *
     * @return service interface.
     */
    Class<T> getInterface();

    /**
     * invoke.
     *
     * @param invocation
     * @return result
     * @throws RpcException
     */
    Result invoke(Invocation invocation) throws RpcException;









    /*
      集群版Invoker:
      client端，拥有某个服务的多个Invoker，此时client端需要做的就是将多个Invoker聚合成一个集群版的Invoker，
      client端使用的时候，仅仅通过集群版的Invoker来进行操作。
      集群版的Invoker会从众多的远程通信类型的Invoker中选择一个来执行（从中加入负载均衡、服务降级等策略）
      类似服务治理













     */
}

