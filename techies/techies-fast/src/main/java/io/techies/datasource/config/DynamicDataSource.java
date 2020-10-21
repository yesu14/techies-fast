/**
 * Copyright (c) 2020 Techies-RG All rights reserved.
 *
 * 版权所有，侵权必究！
 */

package io.techies.datasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 多数据源
 *
 * @author Techies-RG
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicContextHolder.peek();
    }

}
