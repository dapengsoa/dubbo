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
package com.alibaba.dubbo.registry;

import com.alibaba.dubbo.common.URL;

import java.util.List;

/**
 * NotifyListener. (API, Prototype, ThreadSafe)
 *
 * @see com.alibaba.dubbo.registry.RegistryService#subscribe(URL, NotifyListener)
 */
public interface NotifyListener {

    /**
     * 当收到 服务变更通知时 触发
     * <p>
     * 通知需要支持如下条约:
     * 1。总是在服务接口和数据类型的维度上通知。也就是说，不会将属于同一服务的同一类型数据通知部分。用户不需要比较之前通知的结果。
     * 2。订阅的第一个通知必须是对服务的所有类型数据的完整通知。
     * 3。在更改时，可以分别通知不同类型的数据，例如:提供者、使用者、路由器和重写。它只允许通知其中一种类型，但是这种类型的数据必须是完整的，而不是增量的。
     * 4。如果数据类型为空，则需要将url数据的类别参数标识通知空协议。
     * 5。通知的顺序由通知(即注册表的实现)保证。例如:单线程推送、队列序列化和版本比较。
     *
     * @param urls url的注册信息列表，总是不空的。其含义与{@link com.alibaba.dubbo.registry.RegistryService#lookup(URL)}的返回值相同。* /
     */
    void notify(List<URL> urls);

}