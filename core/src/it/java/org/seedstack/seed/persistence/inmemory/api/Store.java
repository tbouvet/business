/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.seed.persistence.inmemory.api;

import org.seedstack.seed.transaction.api.Transactional;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.seedstack.seed.transaction.api.Propagation.REQUIRES_NEW;


/**
 * This annotation can be used on tests to specify manually which storage in memory SEED should load.
 *
 * @author redouane.loulou@ext.mpsa.com
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Transactional(propagation = REQUIRES_NEW)
public @interface Store {
    /**
     * @return the name of the in-memory store.
     */
    String value();

}